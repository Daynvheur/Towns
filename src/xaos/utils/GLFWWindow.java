package xaos.utils;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.awt.image.*;
import java.nio.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * GLFW-based window manager replacing LWJGL 2 Display class.
 * Provides a compatible API surface for the Towns game.
 */
public final class GLFWWindow {

    private static long window;
    private static boolean fullscreen = false;
    private static int width = 1024;
    private static int height = 600;
    private static int lastWindowWidth = 1024;
    private static int lastWindowHeight = 600;

    // Callback references to prevent GC
    private static GLFWWindowCloseCallbackI windowCloseCallbackObj;
    private static GLFWWindowSizeCallbackI windowResizeCallbackObj;
    private static GLFWCursorPosCallbackI cursorPosCallbackObj;
    private static GLFWMouseButtonCallbackI mouseButtonCallbackObj;
    private static GLFWScrollCallbackI scrollCallbackObj;
    private static GLFWKeyCallbackI keyCallbackObj;

    // Mouse state
    private static int mouseX = 0, mouseY = 0;
    private static int mouseButton = -1;
    private static boolean mouseButtonState = false;
    private static int mouseWheelDelta = 0;
    private static boolean mouseEventAvailable = false;

    // Keyboard state
    private static final int[] glfwKeyState = new int[512];
    private static int eventKey = GLFW_KEY_UNKNOWN;
    private static boolean eventKeyState = false;
    private static boolean keyEventAvailable = false;

    // Native cursor
    private static long cursorHandle = NULL;

    private GLFWWindow() {}

    /**
     * Initialize the GLFW window.
     */
    public static void init(int w, int h, boolean fs) throws Exception {
        width = w;
        height = h;
        fullscreen = fs;

        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 2);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 1);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        long monitor = fs ? glfwGetPrimaryMonitor() : NULL;

        if (monitor != NULL) {
            GLFWVidMode mode = glfwGetVideoMode(monitor);
            if (mode != null) {
                w = mode.width();
                h = mode.height();
            }
        }

        window = glfwCreateWindow(w, h, "Towns", monitor, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);

        GL.createCapabilities();

        IntBuffer wBuf = memAllocInt(1);
        IntBuffer hBuf = memAllocInt(1);
        glfwGetWindowSize(window, wBuf, hBuf);
        lastWindowWidth = wBuf.get(0);
        lastWindowHeight = hBuf.get(0);
        memFree(wBuf);
        memFree(hBuf);

        setupCallbacks();
    }

    private static void setupCallbacks() {
        windowCloseCallbackObj = (win) -> {};
        glfwSetWindowCloseCallback(window, windowCloseCallbackObj);

        windowResizeCallbackObj = (win, w, h) -> {
            width = w;
            height = h;
            glfwMakeContextCurrent(win);
            GL11.glViewport(0, 0, w, h);
        };
        glfwSetWindowSizeCallback(window, windowResizeCallbackObj);

        cursorPosCallbackObj = (win, x, y) -> {
            mouseX = (int) x;
            mouseY = (int) y;
        };
        glfwSetCursorPosCallback(window, cursorPosCallbackObj);

        mouseButtonCallbackObj = (win, btn, action, mods) -> {
            mouseButton = btn;
            mouseButtonState = action == GLFW_PRESS;
            mouseEventAvailable = true;
        };
        glfwSetMouseButtonCallback(window, mouseButtonCallbackObj);

        scrollCallbackObj = (win, xoff, yoff) -> {
            mouseWheelDelta = yoff > 0 ? 1 : (yoff < 0 ? -1 : 0);
            mouseEventAvailable = true;
        };
        glfwSetScrollCallback(window, scrollCallbackObj);

        keyCallbackObj = (win, key, scancode, action, mods) -> {
            if (key >= 0 && key < glfwKeyState.length) {
                glfwKeyState[key] = action;
            }
            if (action == GLFW_PRESS || action == GLFW_REPEAT) {
                eventKey = key;
                eventKeyState = true;
                keyEventAvailable = true;
            } else if (action == GLFW_RELEASE) {
                eventKey = key;
                eventKeyState = false;
                keyEventAvailable = true;
            }
        };
        glfwSetKeyCallback(window, keyCallbackObj);
    }

    // ==================== Display-compatible API ====================

    public static boolean isCloseRequested() {
        return glfwWindowShouldClose(window);
    }

    public static void update() {
        glfwSwapBuffers(window);
    }

    public static void pollEvents() {
        glfwPollEvents();
    }

    public static void sync(int fps) {
        if (fps <= 0) return;
        long frameStart = System.nanoTime();
        long targetInterval = 1_000_000_000L / fps;
        long elapsed = System.nanoTime() - frameStart;
        long sleepTime = targetInterval - elapsed;
        if (sleepTime > 1_000_000) {
            try {
                Thread.sleep(sleepTime / 1_000_000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static boolean wasResized() {
        IntBuffer wBuf = memAllocInt(1);
        IntBuffer hBuf = memAllocInt(1);
        glfwGetWindowSize(window, wBuf, hBuf);
        boolean resized = (wBuf.get(0) != width || hBuf.get(0) != height);
        memFree(wBuf);
        memFree(hBuf);
        return resized;
    }

    public static int getWidth() {
        IntBuffer buf = memAllocInt(1);
        glfwGetWindowSize(window, buf, null);
        int w = buf.get(0);
        memFree(buf);
        return w;
    }

    public static int getHeight() {
        IntBuffer buf = memAllocInt(1);
        glfwGetWindowSize(window, null, buf);
        int h = buf.get(0);
        memFree(buf);
        return h;
    }

    public static boolean isFullscreen() {
        return fullscreen;
    }

    public static void setFullscreen(boolean fs) {
        if (fullscreen == fs) return;
        fullscreen = fs;
        if (fs) {
            GLFWVidMode mode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            if (mode != null) {
                glfwSetWindowMonitor(window, glfwGetPrimaryMonitor(), 0, 0, mode.width(), mode.height(), GLFW_DONT_CARE);
            }
        } else {
            glfwSetWindowMonitor(window, NULL, 100, 100, lastWindowWidth, lastWindowHeight, GLFW_DONT_CARE);
        }
    }

    public static void setVSyncEnabled(boolean enabled) {
        glfwSwapInterval(enabled ? 1 : 0);
    }

    public static void setTitle(String title) {
        glfwSetWindowTitle(window, title);
    }

    public static void destroy() {
        // CallbackI interfaces don't need explicit cleanup in LWJGL 3.3.5
        if (cursorHandle != NULL) glfwDestroyCursor(cursorHandle);
        if (window != NULL) glfwDestroyWindow(window);
        glfwTerminate();
    }

    // ==================== Icon handling ====================

    public static void setIcon(BufferedImage icon) {
        if (icon == null) return;

        int w = icon.getWidth();
        int h = icon.getHeight();
        int[] pixels = new int[w * h];
        icon.getRGB(0, 0, w, h, pixels, 0, w);

        // Convert ARGB to RGBA
        int[] rgba = new int[w * h];
        for (int i = 0; i < pixels.length; i++) {
            int p = pixels[i];
            rgba[i] = ((p >> 8) & 0x00FFFFFF) | (p & 0xFF000000);
        }

        ByteBuffer buf = ByteBuffer.allocateDirect(w * h * 4);
        for (int p : rgba) {
            buf.putInt(p);
        }
        buf.flip();
        
        GLFWImage.Buffer bufImage = GLFWImage.malloc(1);
        bufImage.width(w);
        bufImage.height(h);
        bufImage.pixels(buf);

        cursorHandle = glfwCreateCursor(bufImage.get(0), 0, h - 1);
        GLFWImage.Buffer bufIcon = GLFWImage.malloc(1);
        bufIcon.width(w);
        bufIcon.height(h);
        bufIcon.pixels(buf);
        glfwSetWindowIcon(window, bufIcon);

        bufImage.free();
        bufIcon.free();
    }

    // ==================== Native cursor handling ====================

    public static void setNativeCursor(int w, int h, int hotX, int hotY, IntBuffer pixels) {
        if (cursorHandle != NULL) {
            glfwDestroyCursor(cursorHandle);
            cursorHandle = NULL;
        }

        pixels.rewind();
        int[] pixelArray = new int[pixels.remaining()];
        pixels.get(pixelArray);
        
        ByteBuffer buf = ByteBuffer.allocateDirect(w * h * 4);
        for (int p : pixelArray) {
            buf.putInt(p);
        }
        buf.flip();
        
        GLFWImage.Buffer bufImage = GLFWImage.malloc(1);
        bufImage.width(w);
        bufImage.height(h);
        bufImage.pixels(buf);

        cursorHandle = glfwCreateCursor(bufImage.get(0), hotX, hotY);
        bufImage.free();

        if (window != NULL) {
            glfwSetCursor(window, cursorHandle);
        }
    }

    // ==================== Mouse-compatible API ====================

    public static int getEventX() {
        return mouseX;
    }

    public static int getEventY() {
        return height - mouseY - 1;
    }

    public static int getX() {
        return mouseX;
    }

    public static int getY() {
        return height - mouseY - 1;
    }

    public static boolean next() {
        boolean available = mouseEventAvailable;
        mouseEventAvailable = false;
        return available;
    }

    public static int getEventButton() {
        return mouseButton;
    }

    public static boolean getEventButtonState() {
        return mouseButtonState;
    }

    public static int getEventDWheel() {
        return mouseWheelDelta;
    }

    public static boolean isInsideWindow() {
        return mouseX >= 0 && mouseX < width && mouseY >= 0 && mouseY < height;
    }

    public static boolean isPressed(int button) {
        return glfwGetMouseButton(window, button) == GLFW_PRESS;
    }

    public static void resetMouseEvent() {
        mouseEventAvailable = false;
        mouseButton = -1;
        mouseWheelDelta = 0;
    }

    // ==================== Keyboard-compatible API ====================

    public static boolean keyNext() {
        boolean available = keyEventAvailable;
        keyEventAvailable = false;
        return available;
    }

    public static int getEventKey() {
        return eventKey;
    }

    public static boolean getEventKeyState() {
        return eventKeyState;
    }

    public static boolean isKeyPressed(int key) {
        if (key >= 0 && key < glfwKeyState.length) {
            return glfwKeyState[key] == GLFW_PRESS;
        }
        return false;
    }

    private static void resetKeyEvent() {
        keyEventAvailable = false;
        eventKey = GLFW_KEY_UNKNOWN;
        eventKeyState = false;
    }

    // ==================== Sys-compatible API ====================

    public static long getTimerResolution() {
        return 1000L;
    }

    public static long getTime() {
        return System.currentTimeMillis();
    }

    // ==================== Internal helpers ====================

    public static long getWindow() {
        return window;
    }

    public static DisplayMode getDesktopDisplayMode() {
        long monitor = glfwGetPrimaryMonitor();
        if (monitor == NULL) {
            return new DisplayMode(1920, 1080, 32, 60);
        }
        GLFWVidMode mode = glfwGetVideoMode(monitor);
        if (mode == null) {
            return new DisplayMode(1920, 1080, 32, 60);
        }
        return new DisplayMode(mode.width(), mode.height(), 32, mode.refreshRate());
    }

    public static DisplayMode[] getAvailableDisplayModes() {
        long monitor = glfwGetPrimaryMonitor();
        if (monitor == NULL) {
            return new DisplayMode[0];
        }
        GLFWVidMode mode = glfwGetVideoMode(monitor);
        if (mode == null) {
            return new DisplayMode[0];
        }
        return new DisplayMode[]{
            new DisplayMode(mode.width(), mode.height(), 32, mode.refreshRate())
        };
    }

    public static void setDisplayMode(int w, int h) {
        if (fullscreen) {
            long monitor = glfwGetPrimaryMonitor();
            GLFWVidMode mode = glfwGetVideoMode(monitor);
            if (mode != null) {
                glfwSetWindowMonitor(window, monitor, 0, 0, w, h, GLFW_DONT_CARE);
            }
        } else {
            glfwSetWindowSize(window, w, h);
            lastWindowWidth = w;
            lastWindowHeight = h;
        }
    }

    public static void setDisplayModeAndFullscreen(int w, int h, int freq) {
        long monitor = glfwGetPrimaryMonitor();
        fullscreen = true;
        GLFWVidMode mode = glfwGetVideoMode(monitor);
        int refreshRate = freq == GLFW_DONT_CARE ? (mode != null ? mode.refreshRate() : 60) : freq;
        glfwSetWindowMonitor(window, monitor, 0, 0, w, h, refreshRate);
    }

    public static int getDisplayModeFrequency() {
        long monitor = glfwGetPrimaryMonitor();
        if (monitor == NULL) return 60;
        GLFWVidMode mode = glfwGetVideoMode(monitor);
        if (mode == null) return 60;
        return mode.refreshRate();
    }

    public static int getDisplayModeBitsPerPixel() {
        return 32;
    }
}

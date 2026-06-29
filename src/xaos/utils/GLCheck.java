package xaos.utils;

import java.nio.IntBuffer;
import java.nio.ByteBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * Test program to check OpenGL limits and maximum window size support.
 * Run this to diagnose viewport/texture/renderbuffer size limitations.
 */
public class GLCheck {

    public static void main(String[] args) {
        System.out.println("=== OpenGL Limits Check ===\n");

        // Initialize GLFW
        if (!glfwInit()) {
            System.err.println("Failed to initialize GLFW");
            return;
        }

        // Get OpenGL limits
        IntBuffer maxViewport = memAllocInt(1);
        IntBuffer maxTextureSize = memAllocInt(1);

        try {
            glGetIntegerv(GL_MAX_VIEWPORT_DIMS, maxViewport);
            glGetIntegerv(GL_MAX_TEXTURE_SIZE, maxTextureSize);

            System.out.println("GL_MAX_VIEWPORT_DIMS: " + maxViewport.get(0));
            System.out.println("GL_MAX_TEXTURE_SIZE: " + maxTextureSize.get(0));
        } finally {
            memFree(maxViewport);
            memFree(maxTextureSize);
        }

        // Try to create a large window
        System.out.println("\n=== Window Size Test ===");
        int testWidth = 24000; // Triple 8K width
        int testHeight = 8000; // 8K height

        System.out.println("Attempting to create window: " + testWidth + "x" + testHeight);

        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        long testWindow = glfwCreateWindow(testWidth, testHeight, "GL Check - Large Window", NULL, NULL);

        if (testWindow == NULL) {
            PointerBuffer errorPtr = memAllocPointer(1);
            int error = glfwGetError(errorPtr);
            memFree(errorPtr);
            System.err.println("FAILED: Could not create window of size " + testWidth + "x" + testHeight);
            System.err.println("GLFW Error code: " + error);
        } else {
            System.out.println("SUCCESS: Window created successfully!");
            IntBuffer wBuf = memAllocInt(1);
            IntBuffer hBuf = memAllocInt(1);
            glfwGetWindowSize(testWindow, wBuf, hBuf);
            System.out.println("Actual window size: " + wBuf.get(0) + "x" + hBuf.get(0));
            memFree(wBuf);
            memFree(hBuf);

            // Try to make context current and check viewport
            glfwMakeContextCurrent(testWindow);
            GL.createCapabilities();

            IntBuffer viewport = memAllocInt(4);
            glGetIntegerv(GL_VIEWPORT, viewport);
            System.out.println("Viewport: x=" + viewport.get(0) + " y=" + viewport.get(1) +
                             " w=" + viewport.get(2) + " h=" + viewport.get(3));
            memFree(viewport);

            // Try to set a large viewport
            System.out.println("\n=== Viewport Test ===");
            System.out.println("Attempting to set viewport: " + testWidth + "x" + testHeight);
            glViewport(0, 0, testWidth, testHeight);
            glGetIntegerv(GL_VIEWPORT, viewport);
            System.out.println("Actual viewport: w=" + viewport.get(2) + " h=" + viewport.get(3));
            memFree(viewport);

            glfwDestroyWindow(testWindow);
        }

        glfwTerminate();
        System.out.println("\n=== Test Complete ===");
    }
}

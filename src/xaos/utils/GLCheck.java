import java.nio.IntBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.*;
import org.lwjgl.system.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

public class GLCheck {
    public static void main(String[] args) {
        System.out.println("=== GLFW Window Size Test ===\n");

        if (!glfwInit()) {
            System.err.println("Failed to initialize GLFW");
            return;
        }

        System.out.println("=== Monitor Info ===");
        long monitor1 = glfwGetPrimaryMonitor();
        if (monitor1 != NULL) {
            GLFWVidMode mode1 = glfwGetVideoMode(monitor1);
            if (mode1 != null) {
                System.out.println("Monitor 1 (primary): " + mode1.width() + "x" + mode1.height());
            }
        }

        // Try to get all monitors
        PointerBuffer monitors = glfwGetMonitors();
        int monitorCount = monitors.remaining();
        System.out.println("Total monitors: " + monitorCount);

        for (int i = 0; i < monitorCount; i++) {
            monitors.position(i);
            long monitor = monitors.get();
            GLFWVidMode mode = glfwGetVideoMode(monitor);
            if (mode != null) {
                String name = glfwGetMonitorName(monitor);
                System.out.println("Monitor " + (i+1) + " (" + name + "): " + mode.width() + "x" + mode.height());
            }
        }

        System.out.println("\n=== Window Size Test ===");
        int testWidth = 24000;
        int testHeight = 8000;

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

            // Try smaller sizes
            System.out.println("\n=== Smaller Window Tests ===");
            int[][] sizes = {{16384, 8000}, {16385, 8000}, {16000, 8000}, {20000, 8000}};
            for (int[] size : sizes) {
                long win = glfwCreateWindow(size[0], size[1], "Test " + size[0] + "x" + size[1], NULL, NULL);
                if (win == NULL) {
                    System.err.println("FAILED: " + size[0] + "x" + size[1]);
                } else {
                    IntBuffer wb = memAllocInt(1);
                    IntBuffer hb = memAllocInt(1);
                    glfwGetWindowSize(win, wb, hb);
                    System.out.println("SUCCESS: " + size[0] + "x" + size[1] + " -> actual: " + wb.get(0) + "x" + hb.get(0));
                    memFree(wb);
                    memFree(hb);
                    glfwDestroyWindow(win);
                }
            }

            glfwDestroyWindow(testWindow);
        }

        glfwTerminate();
        System.out.println("\n=== Test Complete ===");
    }
}

package renderEngine;

//import org.lwjgl.LWJGLException;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.*;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class DisplayManager {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS = 120;
    private static GLFWErrorCallback errorCallback;
    private static long windowId;

    public static void createDisplay() {
        glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));

        if (!glfwInit()) {
            throw new IllegalStateException("GLFW init failed.");
        }

        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        windowId = glfwCreateWindow(WIDTH, HEIGHT, "LWJGL demo", MemoryUtil.NULL, MemoryUtil.NULL);

        if (windowId == MemoryUtil.NULL) {
            throw new IllegalStateException("Window failed.");
        }

        // link GLFW context
        glfwMakeContextCurrent(windowId);
        GL.createCapabilities();
        glfwSwapInterval(1);    // passing 1 enables Vsync
        glfwShowWindow(windowId);
    }

    public static void updateDisplay() {
        while (glfwWindowShouldClose(windowId) == false) {
            render();
        }
    }

    private static void render() {
        glClear(GL_COLOR_BUFFER_BIT);
        glfwSwapBuffers(windowId);          // swaps front and back frame buffers
        glfwPollEvents();                   // checks mouse and keyboard input
    }

    public static void closeDisplay() {
        // Closes the game window
        glfwDestroyWindow(windowId);
        glfwTerminate();
    }
}

package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class DisplayManager {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS = 120;

    public static void createDisplay(){

        // Choose what OpenGL Version to use
        ContextAttribs attribs = new ContextAttribs(3,2);
        attribs.withForwardCompatible(true);
        attribs.withProfileCore(true);

        try {
            // Creates a new window using provided width/height
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), attribs);
            // Sets the title of the game window
            Display.setTitle("Java Game");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        // Sets the viewport of the game window, first 2 params are the coords of the bottom left of the window,
        // and the 3rd and 4th params are the top right of the game window.
        GL11.glViewport(0,0,WIDTH, HEIGHT);
    }
    public static void updateDisplay(){
        // Sets the games fps to run at
        Display.sync(FPS);
        Display.update();
    }
    public static void closeDisplay(){
        // Closes the game window
        Display.destroy();
    }
}

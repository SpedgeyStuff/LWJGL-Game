package engineTester;

import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;

public class MainGameLoop {
    public static void main(String[] args) {

        // Creates the display window
        DisplayManager.createDisplay();

        // While the red X isn't pressed
        while (!Display.isCloseRequested()) {
            DisplayManager.updateDisplay();
        }

        // Once the red X has been pressed
        DisplayManager.closeDisplay();

    }
}

package engineTester;

import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;

public class MainGameLoop {
    public static void main(String[] args) {

        // Creates the display window
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        RawModel model = loader.loadToVAO();

        float[] vertices = {
                -0.5f, 0.5f, 0f,
                -0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, 0.5f, 0f,
                -0.5f, 0.5f, 0f
        };

        // While the red X isn't pressed
        while (!Display.isCloseRequested()) {
            renderer.preRender();
            renderer.render(model);
            DisplayManager.updateDisplay();
        }

        // Once the red X has been pressed
        DisplayManager.closeDisplay();

    }
}

package engineTester;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {
    public static void main(String[] args) {

        // Creates the display window
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        float[] vertices = {
                -0.5f, 0.5f, 0f,
                -0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, 0.5f, 0f,
                -0.5f, 0.5f, 0f
        };

        RawModel model = loader.loadToVAO(vertices);

        while (!DisplayManager.isCloseRequested()) {
            renderer.preRender();
            renderer.render(model);
            DisplayManager.updateDisplay();
        }
        // Once the red X has been pressed
        DisplayManager.closeDisplay();

    }
}

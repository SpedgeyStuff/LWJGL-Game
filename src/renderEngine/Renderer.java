package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Renderer {

    public void preRender(){
        GL11.glClearColor(1, 0, 0, 1);
    }

    public void render(RawModel model){
        GL30.glBindVertexArray(model.getVaoId());         // bind the VAO for the related model
        GL20.glEnableVertexAttribArray(0);          // activate attribute list for the model's VAO
        GL11.glDrawArrays(GL11.GL_TRIANGLE_FAN, 0, model.getVertexCount()); // render
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);                         //unbind VAO
    }
}

package renderEngine;

// class for a raw 3D model stored in memory

public class RawModel {

    private int vaoId;
    private int vertexCount;

    public RawModel(int vaoId, int vertexCount){
        this.vaoId = vaoId;
        this.vertexCount = vertexCount;
    }

    public int getVaoId() {
        return vaoId;
    }

    public int getVertexCount() {
        return vertexCount;
    }
}

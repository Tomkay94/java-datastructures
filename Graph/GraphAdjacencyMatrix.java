public class GraphAdjacencyMatrix {

  private boolean[][] adjMatrix;
  private int numVertexes;

  public GraphAdjacencyMatrix(int numVertexes) {
    this.numVertexes = numVertexes;
    this.adjMatrix = new boolean[numVertexes][numVertexes];
  }

  protected void addEdge(int i, int j) {
    if (i >= 0 && i < numVertexes && j > 0 && j < numVertexes) {
      adjMatrix[i][j] = true;
      adjMatrix[j][i] = true;
    }
  }

  protected void removeEdge(int i, int j) {
    if (i >= 0 && i < numVertexes && j > 0 && j < numVertexes) {
      adjMatrix[i][j] = false;
      adjMatrix[j][i] = false;
    }
  }

  protected boolean isEdge(int i, int j) {
    if (i >= 0 && i < numVertexes && j > 0 && j < numVertexes) {
      return adjMatrix[i][j];
    }
    else {
      return false;
    }
  }
}

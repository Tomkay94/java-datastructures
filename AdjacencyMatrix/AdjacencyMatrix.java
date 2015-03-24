public class AdjacencyMatrix {

  private boolean[][] adjMatrix;
  private int numVertexes;

  public AdjacencyMatrix(int numVertexes) {
    this.numVertexes = numVertexes;
    this.adjMatrix = new boolean[numVertexes][numVertexes];
  }

  /* Add an edge between i and j. */
  protected void addEdge(int i, int j) {
    if (i >= 0 && i < numVertexes && j > 0 && j < numVertexes) {
      adjMatrix[i][j] = true;
      adjMatrix[j][i] = true;
    }
  }

  /* Remove the edge between i and j. */
  protected void removeEdge(int i, int j) {
    if (i >= 0 && i < numVertexes && j > 0 && j < numVertexes) {
      adjMatrix[i][j] = false;
      adjMatrix[j][i] = false;
    }
  }

  /* Return true if there exists an edge between i and j. */
  protected boolean isEdge(int i, int j) {
    if (i >= 0 && i < numVertexes && j > 0 && j < numVertexes) {
      return adjMatrix[i][j];
    }
    else {
      return false;
    }
  }
}

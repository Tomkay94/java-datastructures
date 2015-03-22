import java.util.List;
import java.util.ArrayList;

/* Implements an adjacency list. */
class GraphAdjacencyList<T> {

  private ArrayList<Node<T>> adjacencyList;

  public GraphAdjacencyList() {
    this.adjacencyList = new ArrayList<Node<T>>();
  }
}

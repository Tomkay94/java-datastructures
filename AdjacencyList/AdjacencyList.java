import java.util.List;
import java.util.ArrayList;

/* Implements an adjacency list using linked lists. */

class AdjacencyList<T> {

  private List<Node<T>> adjacencyList;

  public AdjacencyList(int size) {
    this.adjacencyList = new ArrayList<Node<T>>(size);
  }

  /* Return true if firstNode points to secondNode. */
  protected boolean hasDirectedEdge(T firstNode, T secondNode) {
    return true;
  }

  /* Return true if both firstNode and secondNode point to each other. */
  protected boolean hasUndirectedEdge(T firstNode, T secondNode) {
    return true;
  }

  /* Add an edge from firstNode to secondNode. */
  protected void addDirectedEdge(T firstNode, T secondNode) {
    return;
  }

  /* Add an edge from firstNode and secondNode, and
     add another edge from secondNode to firstNode. */
  protected void addUndirectedEdge(T firstNode, T secondNode) {
    return;
  }

  /* Remove the edge from firstNode to secondNode. */
  protected void removeDirectedEdge(T firstNode, T secondNode) {
    return;
  }

  /* Remove the edge from firstNode and secondNode, and
     remove the edge from secondNode to firstNode. */
  protected void removeUndirectedEdge(T firstNode, T secondNode) {
    return;
  }

  /* Display the AdjacencyList in a readable format. */
  protected void show() {
    return;
  }

  /* Return the head node of the linked list at index. */
  private Node getNodeAtIndex(int index) {
    return this.adjacencyList.get(index);
  }
}

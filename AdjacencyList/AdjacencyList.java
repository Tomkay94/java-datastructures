import java.util.List;
import java.util.ArrayList;

/* Implements an adjacency list using linked lists. */

class AdjacencyList<T> {

  private List<Node<T>> adjacencyList;
  private int numEdges;

  public AdjacencyList() {
    this.numEdges = 0;
    this.adjacencyList = new ArrayList<Node<T>>();
  }

  /* Return true if firstNode points to secondNode. */
  protected boolean hasDirectedEdge(T firstNode, T secondNode) {
    return false;
  }

  /* Return true if both firstNode and secondNode point to each other. */
  protected boolean hasUndirectedEdge(T firstNode, T secondNode) {
    // return (
    //   hasDirectedEdge(firstNode, secondNode) &&
    //   hasDirectedEdge(secondNode, firstNode)
    // );
    return false;
  }

  /* Add an edge from firstNode to secondNode. */
  protected void addDirectedEdge(T firstNode, T secondNode) {
    /* Check if this node exists. */
    if (this.containsNodeHead(firstNode)) {
      this.adjacencyList.add(new Node<T>(firstNode));
      System.out.println("found " + firstNode);
    }
    this.appendNodeAtIndex(new Node<T>(firstNode), new Node<T>(secondNode));
    ++this.numEdges;
    return;
  }

  /* Add an edge from firstNode and secondNode, and
     add another edge from secondNode to firstNode. */
  protected void addUndirectedEdge(T firstNode, T secondNode) {
    // this.addDirectedEdge(firstNode, secondNode);
    // this.addDirectedEdge(secondNode, firstNode);
    // this.numEdges += 2;
    return;
  }

  /* Remove the edge from firstNode to secondNode. */
  protected void removeDirectedEdge(T firstNode, T secondNode) {
    return;
  }

  /* Remove the edge from firstNode and secondNode, and
     remove the edge from secondNode to firstNode. */
  protected void removeUndirectedEdge(T firstNode, T secondNode) {
    // this.removeDirectedEdge(firstNode, secondNode);
    // this.removeDirectedEdge(secondNode, firstNode);
    // this.numEdges -= 2;
    return;
  }

  /* Display the AdjacencyList in a readable format. */
  protected void show() {
    for (Node n : this.adjacencyList) {
      n.showTraverse();
    }
    return;
  }

  /* Return the number of linked lists in the adjacency list. */
  protected int getNumEdges() {
    return this.numEdges;
  }

  /* Append the node at the linked list head determined by index. */
  private void appendNodeAtIndex(Node<T> head, Node<T> newNode) {
    int headIndex = 0;
    if (this.containsNodeHead(head.data)) {
      headIndex = adjacencyList.indexOf(head);
      this.adjacencyList.get(headIndex).appendToTail(newNode);
    }

    else {
      this.adjacencyList.get(this.adjacencyList.size()).appendToTail(newNode);
    }
    return;
  }

  /* Return true if there exists a node with value in the adjacency root mapping. */
  private boolean containsNodeHead(T value) {
    for (Node node : this.adjacencyList) {
      if (node.data.equals(value)) {
        return true;
      }
    }
    return false;
  }

  /* Return the head node of the linked list at index. */
  private Node getNodeAtIndex(int index) {
    return this.adjacencyList.get(index);
  }
}

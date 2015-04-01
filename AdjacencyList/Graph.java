
/* Implements an adjacency list graph
   using a linked list of nodes.
*/

/*
Type structure of the adjacency list:

  Node -> Node -> Node -> Node -> ... -> null
   V
  Node -> Node -> ... -> null
   V
  Node -> Node -> Node -> ... -> null
   V
  null
*/
public class Graph<T> {

  private int numEdges;
  private Node<T> adjList;

  public AdjacencyList() {
    this.numEdges = 0;
    this.adjList  = null;
  }

  /* Return true if firstData points to secondData. */
  protected boolean hasDirectedEdge(T firstData, T secondData) {
    if (this.adjList.hasNodeData(firstData)) {
      Node<T> head = this.adjList.getNodeWithData(firstData);
      return (head.next.hasNodeData(secondData));
    }
    return false;
  }

  /* Return true if both firstData and secondData point to each other. */
  protected boolean hasUndirectedEdge(T firstData, T secondData) {
    return (
      this.hasDirectedEdge(firstData, secondData) &&
      this.hasDirectedEdge(secondData, firstData)
    );
  }

  /* Add an edge from firstData to secondData. */
  protected void addDirectedEdge(T firstData, T secondData) {
    /* Check if this node exists. */
    if (this.adjList.hasNodeData(firstData)) {
      // check for the second node in that first node
    }
    // ++this.numEdges;
    return;
  }

  /* Add an edge from firstData and secondData, and
     add another edge from secondData to firstData. */
  protected void addUndirectedEdge(T firstData, T secondData) {
    // this.addDirectedEdge(firstData, secondData);
    // this.addDirectedEdge(secondData, firstData);
    // this.numEdges += 2;
    return;
  }

  /* Remove the edge from firstData to secondData. */
  protected void removeDirectedEdge(T firstData, T secondData) {
    return;
  }

  /* Remove the edge from firstData and secondData, and
     remove the edge from secondData to firstData. */
  protected void removeUndirectedEdge(T firstData, T secondData) {
    // this.removeDirectedEdge(firstData, secondData);
    // this.removeDirectedEdge(secondData, firstData);
    // this.numEdges -= 2;
    return;
  }

  /* Display the AdjacencyList in a readable format. */
  protected void show() {
    // Node<T> curr = this;
    // while(curr != null) {
    //   curr.next.showTraverse();
    //   curr = curr.next;
    // }
    return;
  }

  /* Return true if the node exists in the adjacency list. */
  protected boolean nodeWithDataExists(T data) {
    Node<T> head = this.adjList;
    while (head.down != null) {
      if (head.next.hasNodeData(data)) {
        return true;
      }
      head = head.down;
    }
    return false;
  }

  /* Return the number of linked lists in the adjacency list. */
  protected int getNumEdges() {
    return this.numEdges;
  }
}

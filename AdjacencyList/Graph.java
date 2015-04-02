
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

  public Graph() {
    this.numEdges = 0;
    this.adjList  = null;
  }

  /* Return true if firstData points to secondData. */
  protected boolean hasDirectedEdge(T firstData, T secondData) {
    if (this.adjList.hasVertical(firstData)) {
      Node<T> curr = this.adjList;
      while (curr != null) {
        if (curr.data.equals(firstData) && curr.next != null) {
          return (curr.next.hasHorizontal(secondData));
        }
        curr = curr.down;
      }
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

  private Node<T> handleFirstDirectedEdge(T firstData, T secondData) {
    Node<T> head = new Node<T>(firstData);
    Node<T> tail = new Node<T>(secondData);
    head.appendHorizontal(tail);
    ++this.numEdges;
    return head;
  }

  /* Add an edge from firstData to secondData. */
  protected void addDirectedEdge(T firstData, T secondData) {
    Node<T> curr = this.adjList;

    /* First edge added. */
    if (curr == null) {
      this.adjList = handleFirstDirectedEdge(firstData, secondData);
      return;
    }

    if (!this.adjList.hasVertical(firstData)) {
      this.adjList.appendVertical(new Node<T>(firstData));
    }

    /* Add the node to the adjList. */
    while(curr != null) {
      /* We've found the vertical head node. */
      if (curr.data.equals(firstData)) {
        curr.appendHorizontal(new Node<T>(secondData));
      }
      curr = curr.down;
    }

    ++this.numEdges;
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
    Node<T> curr = this.adjList;
    while(curr != null) {
      curr.showTraverse();
      curr = curr.down;
    }
    return;
  }

  /* Return the number of linked lists in the adjacency list. */
  protected int getNumEdges() {
    return this.numEdges;
  }
}

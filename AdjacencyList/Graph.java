
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

  /* Add the edge if it is the first edge in the graph.
     Return the head node with the connected edge.*/
  private Node<T> addFirstEdge(T firstData, T secondData) {
    Node<T> head = new Node<T>(firstData);
    Node<T> tail = new Node<T>(secondData);
    head.appendHorizontal(tail);
    ++this.numEdges;
    return head;
  }

  /* Add an edge from firstData to secondData.
     Return true if the edge was added successfully. */
  protected boolean addDirectedEdge(T firstData, T secondData) {
    Node<T> curr = this.adjList;

    /* First edge added. */
    if (curr == null) {
      this.adjList = addFirstEdge(firstData, secondData);
      return true;
    }

    /* firstData is not a head node in the graph. */
    if (!this.adjList.hasVertical(firstData)) {
      this.adjList.appendVertical(new Node<T>(firstData));
    }

    /* Add the node to the adjList. */
    curr = curr.getHeadNode(firstData);
    if (!curr.hasHorizontal(secondData)) {
      curr.appendHorizontal(new Node<T>(secondData));
      ++this.numEdges;
      return true;
    }
    return false;
  }

  /* Add an edge from firstData and secondData, and
     add another edge from secondData to firstData.
     Return true if both edges were added successfully. */
  protected boolean addUndirectedEdge(T firstData, T secondData) {
    return (
      this.addDirectedEdge(firstData, secondData) &&
      this.addDirectedEdge(secondData, firstData)
    );
  }

  /* Remove the edge from firstData to secondData.
     Return true if the edge was removed successfully.*/
  protected boolean removeDirectedEdge(T firstData, T secondData) {
    /* Nothing to remove. */
    if (this.adjList == null) {
      return false;
    }

    if (this.adjList.hasVertical(firstData)) {
      Node<T> curr = this.adjList;
      curr = curr.getHeadNode(firstData);

      if (curr.hasHorizontal(secondData)) {
        curr = curr.remove(curr, secondData);
        --this.numEdges;
        return true;
      }
    }

    return false;
  }

  /* Remove the edge from firstData and secondData, and
     remove the edge from secondData to firstData. */
  protected void removeUndirectedEdge(T firstData, T secondData) {
    // return (
    //   this.removeDirectedEdge(firstData, secondData) &&
    //   this.removeDirectedEdge(secondData, firstData)
    // );
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

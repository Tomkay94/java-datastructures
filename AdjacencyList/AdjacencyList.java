
/* Implements an adjacency list using linked lists. */

/*
Type structure of the adjacency list:

  HeadNode -> Node -> Node -> Node -> ... -> null
     V
  HeadNode -> Node -> ... -> null
     V
  HeadNode -> Node -> Node -> ... -> null
     V
   null
*/
public class AdjacencyList<T> {

  private int numEdges;
  private HeadNode<T> adjList;

  public AdjacencyList() {
    this.numEdges = 0;
    this.adjList  = null;
  }

  /* Return true if firstData points to secondData. */
  protected boolean hasDirectedEdge(T firstData, T secondData) {
    // if (this.containsNodeHead(firstData)) {
    //   int firstDataIndex = this.adjList.indexOf(new Node<T>(firstData));
    //   return (this.adjList.get(firstDataIndex).nodeWithDataExists(secondData));
    // }
    return false;
  }

  /* Return true if both firstData and secondData point to each other. */
  protected boolean hasUndirectedEdge(T firstData, T secondData) {
    // return (
    //   hasDirectedEdge(firstData, secondData) &&
    //   hasDirectedEdge(secondData, firstData)
    // );
    return false;
  }

  /* Add an edge from firstData to secondData. */
  protected void addDirectedEdge(T firstData, T secondData) {
    /* Check if this node exists. */
    // if (this.containsNodeHead(firstData)) {
    //   this.adjList.add(new Node<T>(firstData));
    //   System.out.println("found " + firstData);
    // }
    // System.out.println("appending node ...");
    // this.appendNodeAtIndex(new Node<T>(firstData), new Node<T>(secondData));
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
    HeadNode<T> curr = this;
    while(curr != null) {
      curr.next.showTraverse();
      curr = curr.next;
    }
    return;
  }

  /* Return the number of linked lists in the adjacency list. */
  protected int getNumEdges() {
    return this.numEdges;
  }

  /* Append the node at the linked list head determined by index. */
  private void appendNodeAtIndex(Node<T> head, Node<T> newNode) {
    return;
  }
}

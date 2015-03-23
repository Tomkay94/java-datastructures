
/* Implements a node in a linked list for GraphAdjacencyList */

class Node<T> {

  protected Node<T> next;
  protected T data;

  public Node (T value) {
    this.data = data;
    this.next = null;
  }

  protected void appendToTail(Node<T> tailNode) {
    Node<T> curr = this;

    while(curr.next != null) {
      curr = curr.next;
    }

    /* Set the end node */
    curr.next = tailNode;
    return;
  }

}

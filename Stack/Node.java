/*
  Implements a node for a stack data structure.
*/
public class Node<T> {

  protected T data;
  protected Node<T> next;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }

  /* Add tailNode to the end of the linked list. */
  protected void appendToTail(Node<T> tailNode) {
    Node<T> curr = this;

    while (curr.next != null) {
      curr = curr.next;
    }

    /* Set the end node */
    curr.next = tailNode;
    return;
  }

  /* Set the current tail to null.
     Return the node before the node set to null. */
  protected Node<T> resetTail() {
    Node<T> removedTail = this.next;
    this.next = null;
    return removedTail;
  }
}

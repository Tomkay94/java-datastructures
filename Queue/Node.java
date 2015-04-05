public class Node<T> {

  protected T data;
  protected Node<T> next;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }

  protected void appendToTail(Node<T> tailNode) {
    Node<T> curr = this;

    while (curr.next != null) {
      curr = curr.next;
    }

    /* Set the end node */
    curr.next = tailNode;
    return;
  }

  /* Delete the node. Returns the new head of the linked list. */
  protected Node<T> resetHead() {
    return this.next;
  }
}

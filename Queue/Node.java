public class Node<T> {

  private T data;
  private Node<T> next;

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
  protected Node<T> remove(Node<T> head, T data) {
    Node<T> curr = head;

    /* Deleting the first node, move the head over. */
    if (curr.data == data) {
      return head.next;
    }

    while (curr.next != null) {
      if (curr.next.data == data) {
        curr.next = curr.next.next;
        return head;
      }
      curr = curr.next;
    }
   return head;
  }

}

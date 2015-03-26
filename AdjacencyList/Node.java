
/* Implements a node in a linked list for GraphAdjacencyList */

public class Node<T> {

  protected T data;
  protected Node<T> next;

  public Node (T data) {
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

  /* Remove the node with data and return the new head node. */
  protected Node<T> remove(Node<T> head, T data) {
    /* Deleting the first node, move the head over. */
    if (this.data == data) {
      return head.next;
    }

    Node<T> curr = head;

    while(curr.next != null) {
      if (curr.next.data == data) {
        curr.next = curr.next.next;
        return curr;
      }
      curr = curr.next;
    }

    return head;
  }

  protected boolean nodeExists(T data) {
    Node curr = this;

    while(curr.data != data) {
      if (curr.next == null) {
        return false;
      }
      curr = curr.next;
    }
    return true;
  }
}

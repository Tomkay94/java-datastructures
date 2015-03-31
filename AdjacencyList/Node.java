
/* Implements a node in a linked list for GraphAdjacencyList */

public class Node<T> {

  protected T data;
  protected Node<T> next;

  public Node (T data) {
    this.data = data;
    this.next = null;
  }

  /* Append the tailNode to the linked list. */
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

  /* Return true if a node with data exists in the linked list.*/
  protected boolean nodeWithDataExists(T data) {
    Node<T> curr = this;

    while(curr.data != data) {
      if (curr.next == null) {
        return false;
      }
      curr = curr.next;
    }
    return true;
  }

  /* Display the linked list. */
  protected void showTraverse() {
    Node<T> curr = this;
    System.out.print("[" + curr.data + "] -> [");
    curr = curr.next;
    while(curr.next != null) {
      System.out.print(curr.data + ", ");
      curr = curr.next;
    }
    System.out.println(curr.data + "]");
  }
}

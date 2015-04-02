
/* Implements a node in a linked list for an adjacency list Graph. */

public class Node<T> {

  protected T data;
  protected Node<T> next;
  protected Node<T> down;

  public Node (T data) {
    this.data = data;
    this.next = null;
    this.down = null;
  }

  /* Append the tailNode to the linked list. */
  protected void appendHorizontal(Node<T> tailNode) {
    Node<T> curr = this;
    while(curr.next != null) {
      curr = curr.next;
    }

    /* Set the end node */
    curr.next = tailNode;
    return;
  }

  /* Add a new Node to the bottom of the linked list. */
  protected void appendVertical(Node<T> head) {
    Node<T> curr = this;
    while (curr.down != null) {
      curr = curr.down;
    }

    /* Set the end node */
    curr.down = head;
    return;
  }

  /* Remove the node with data and return the new head node. */
  protected Node<T> remove(Node<T> head, T data) {
    /* Deleting the first node, move the head over. */
    if (this.data == data) {
      return head.next;
    }

    /* If it's a head node */
    if (head.down == null) {
      // handle it
      // call transferDownLinks(head);
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

  /* If the node being removed is a head node,
     take the next node as usual, but add its
     down links from the node removed, if it had any. */
  // private Node<T> transferDownLinks(Node<T> head) {
  //   return;
  // }

  /* Return true if a node with data exists in the linked list
  with links that are horizontal (see diagram in Graph.java).*/
  protected boolean hasHorizontal(T data) {
    Node<T> curr = this;
    while (curr != null) {
      // System.out.println(curr.data);
      if (curr.data.equals(data)) {
        return true;
      }
      curr = curr.next;
    }
    return false;
  }

  /* Return true if a node with data exists in the linked list
  with links that are vertical (see diagram in Graph.java).*/
  protected boolean hasVertical(T data) {
    Node<T> curr = this;
    while (curr != null) {
      if (curr.data.equals(data)) {
        return true;
      }
      curr = curr.down;
    }
    return false;
  }

  /* Display the linked list. */
  protected void showTraverse() {
    Node<T> curr = this;
    System.out.print("[" + curr.data + "] -> [");
    while(curr.next != null) {
      curr = curr.next;
      System.out.print(curr.data + " ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    // Node<Integer> n1 = new Node<Integer>(5);
    // Node<Integer> n2 = new Node<Integer>(15);
    // Node<Integer> n3 = new Node<Integer>(25);
    // Node<Integer> n4 = new Node<Integer>(35);
    // Node<Integer> n5 = new Node<Integer>(45);
    //
    // // n1.showTraverse();
    // // n1.showTraverse();
    //
    // n1.showTraverse();
    // System.out.println(n1.hasVertical(45));
    // System.out.println(n1.hasHorizontal(45));
    // n1.appendVertical(n2);
    // n1.appendVertical(n3);
    // n1.appendVertical(n4);
    // n1.appendVertical(n5);
    // System.out.println(n1.hasVertical(45));
    // System.out.println(n1.hasHorizontal(45));
    // n1.showTraverse();
  }
}

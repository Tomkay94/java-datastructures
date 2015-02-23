import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/* Implements a single node for a linked list */

public class Node<T> {

  Node<T> next;
  T data;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }

  /* Appends newNode to the end of the linked list */
  protected void appendToTail(Node<T> tailNode) {
    Node<T> curr = this;

    while (curr.next != null) {
      curr = curr.next;
    }

    /* Set the end node */
    curr.next = tailNode;
    return;
  }

  /* Determine if a linked list is circular */
  protected boolean isCircular() {
    Node<T> hopOnce  = this;
    Node<T> hopTwice = this;

    /* Accounts for non-circular linked lists of length < 3 */
    try {
      hopTwice = hopTwice.next.next;
    } catch (NullPointerException e) { return false; }

    while (hopOnce != hopTwice) {

      /* The list has an end Node */
      if (hopTwice == null || hopOnce == null) {
        return false;
      }

      else {
        hopOnce = hopOnce.next;

        /* Account for non-circular linked lists */
        try {
          hopTwice = hopTwice.next.next;
        } catch (NullPointerException e) { return false; }

      }
    }

    return true;
  }

  /* Iterate and display the nodes of the linked list. */
  protected void traverseList() {
    Node<T> curr = this;
    Node<T> head = this;

    do {
      System.out.println(
        "Node: "    + curr +
        "\tValue: " + curr.data
      );
      curr = curr.next;
    /* Accounts for circular linked list traversal */
    } while (curr != null && curr != head);
    return;
  }

  /* Returns the number of elements in the linked list. */
  protected int getLength() {
    Node<T> curr = this;
    Node<T> head = this;
    int listLength = 0;

    do {
      ++listLength;
      curr = curr.next;
    /* Accounts for circular linked list traversal */
    } while (curr != null && curr != head);

    return listLength;
  }

  /* Delete the node from linked list head with data.
  Returns the new head of the linked list. */
  protected Node<T> delete(Node<T> head, T data) {
    Node<T> curr = head;

    /* Deleting the first node, move the head over. */
    if(curr.data == data) {
      return head.next;
    }

    while(curr.next != null) {
      if(curr.next.data == data) {
        curr.next = curr.next.next;
        return head;
      }
      curr = curr.next;
    }
   return head;
  }

  /* Reverse a list. */
  private List<T> _reverseList(List<T> list) {
    int last = list.size() - 1;
    for (int i = 0; i < (list.size() / 2); ++i) {
      Collections.swap(list, i, last - i);
    }
    return list;
  }

  /* Return true if the linked list's values form a palindrome */
  protected boolean isPalindrome() {
    int counter    = 0;
    Node<T> head   = this;
    int listLength = head.getLength();

    /* We will store the values in the first half here */
    List<T> nodeValues = new ArrayList<T>(listLength / 2);

    /* Copy the first half of the linked list into nodeValues */
    while(counter < listLength / 2 && head != null) {
      nodeValues.add(head.data);
      head = head.next;
      ++counter;
    }

    /* Reverse the first half of the linked list's values*/
    nodeValues = _reverseList(nodeValues);

    /* Skip the middle odd element to enforce a same-length
    comparison on the second half of the linked list.*/
    if (listLength % 2 != 0 && listLength > 1) {
      head = head.next;
    }

    /* Start comparing values from the
    second half to the reversed first half.*/
    if (counter == (listLength / 2)) {
      counter = 0;

      while(head.next != null) {
        if (head.data != nodeValues.get(counter)) {
          return false;
        }
        head = head.next;
        ++counter;
      }

    }
    return true;
  }

  /* Find the median element in the linked list */
  protected Node<T> findMedianElement() {
    Node<T> hopOnce  = this;
    Node<T> hopTwice = this;

    while(true) {

      /* Weve reached the end of the list, hopOnce is the median. */
      if (hopTwice.next == null) {
        return hopOnce;
      }

      /* hopTwice is one Node from the end, go to the end */
      else if (hopTwice.next.next == null) {
        hopTwice = hopTwice.next;
      }

      else {
        hopOnce  = hopOnce.next;
        hopTwice = hopTwice.next.next;
      }
    }
  }

}

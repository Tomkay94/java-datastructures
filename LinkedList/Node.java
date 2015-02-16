public class Node {

  Node next = null;
  int data;

  public Node(int d) {
    data = d;
  }

  /* Appends newNode to the end of the linked list */
  private void appendToTail(Node newNode) {
    Node curr = this;

    while (curr.next != null) {
      curr = curr.next;
    }

    /* Set the end node */
    curr.next = newNode;
    return;
  }

  private boolean isCircular() {
    Node hopOnce  = this;
    Node hopTwice = this;

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

        /* Account for non-circular */
        try {
          hopTwice = hopTwice.next.next;
        } catch (NullPointerException e) { return false; }

      }
    }

    return true;
  }

  /* Iterate and display the nodes of the linked list.
  Returns the number of elements in the linked list. */
  private void traverseList() {
    Node curr = this;
    Node head = this;

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

  /* Iterate and display the nodes of the linked list.
  Returns the number of elements in the linked list. */
  private int getLength() {
    Node curr = this;
    Node head = this;
    int listLength = 0;

    do {
      ++listLength;
      curr = curr.next;
    /* Accounts for circular linked list traversal */
    } while (curr != null && curr != head);

    return listLength;
  }


  // Delete the node from linked list n with data
  private void delete(Node n, int data) {
  }

  /* Find the median element in the linked list */
  private Node findMedianElement() {
    Node hopOnce  = this;
    Node hopTwice = this;

    while(true) {

      /* Weve reached the end of the list, hopOnce is the median. */
      if (hopTwice.next == null) {
        System.out.println("End Node Value: \t"    + hopTwice.data);
        System.out.println("Median Node Value: \t" + hopOnce.data);
        return hopOnce;
      }

      /* hopTwice is one Node from the end, go to the end */
      else if (hopTwice.next.next == null) {
        hopTwice = hopTwice.next;
      }

      else {
        hopOnce = hopOnce.next;
        hopTwice = hopTwice.next.next;
      }
    }
  }

  // Example function calls
  public static void main(String[] args) {

    // A regular linked list
    Node head = new Node(10);
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(20));
    head.appendToTail(new Node(25));
    head.appendToTail(new Node(30));
    head.appendToTail(new Node(35));
    head.appendToTail(new Node(40));
    head.appendToTail(new Node(45));

    // A palindrome linked list
    Node palindrome = new Node(10);
    palindrome.appendToTail(new Node(15));
    palindrome.appendToTail(new Node(20));
    palindrome.appendToTail(new Node(15));
    palindrome.appendToTail(new Node(10));

    head.findMedianElement();

    // Makes the list circular
    // head.appendToTail(head);

    System.out.println("Linked list is circular: " + head.isCircular());
    System.out.println("head palindrome? " + head.isPalindrome());
    System.out.println("pal palindrome? " + palindrome.isPalindrome());

  }

}

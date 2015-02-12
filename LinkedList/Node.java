public class Node {

  Node next = null;
  int data;

  public Node(int d) {
    data = d;
  }

  // Appends data to the end of the linked list
  private void appendToTail(int data) {

    Node curr = this;
    Node end  = new Node(data);

    while(curr.next != null) {
      curr = curr.next;
    }

    curr.next = end;
    return;
  }

  // Iterate through the linked list
  private void traverseList() {
    Node curr = this;

    while(curr != null) {
      System.out.println(
        "Node: "    + curr +
        "\tValue: " + curr.data);
      curr = curr.next;
    }
    return;
  }

  // Delete the node from linked list n with data
  private void delete(Node n, int data) {
  }

  // Find the median element in the linked list
  private Node findMedianElement() {
    Node hopOnce  = this;
    Node hopTwice = this;

    while(true) {

      // Weve reached the end of the list, hopOnce is the median.
      if (hopTwice.next == null) {
        System.out.println("End Node Value: \t"    + hopTwice.data);
        System.out.println("Median Node Value: \t" + hopOnce.data);
        return hopOnce;
      }

      // hopTwice is one Node from the end, go to the end
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

    Node head = new Node(10);
    head.appendToTail(15);
    head.appendToTail(20);
    head.appendToTail(25);
    head.appendToTail(30);
    head.appendToTail(35);
    head.appendToTail(40);
    head.appendToTail(45);

    head.traverseList();
    head.findMedianElement();
  }

}

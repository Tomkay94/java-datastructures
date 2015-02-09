public class Node {

  Node next = null;
  int data;

  public Node(int d) {
    data = d;
  }

  // Appends data to the end of the linked list
  private void appendToTail(int data) {

    Node curr = this;
    Node end = new Node(data);

    while(curr.next != null) {
      curr = curr.next;
    }

    curr.next = end;
  }

  // Iterate through the linked list
  private void traverseList() {
  }

  // Delete the node from linked list n with data
  private void delete(Node n, int data) {
  }

  // Example
  public static void main(String[] args) {

    Node head = new Node(10);

  }

}

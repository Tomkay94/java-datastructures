
/* Acts as a single node in a Binary Search Tree */

public class Node {

  protected Node leftChild;
  protected Node rightChild;
  protected int key;
  protected String data;

  public Node(int key, String data) {
    this.key = key;
    this.data = data;
    this.leftChild = null;
    this.rightChild = null;
  }

  @Override
  public String toString() {
    return this.key + " has data: " + this.data;
  }
}

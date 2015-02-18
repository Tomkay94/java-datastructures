
/* Acts as a single node in a Binary Search Tree */

public class Node {

  protected Node left;
  protected Node right;
  protected int key;
  protected String data;

  public Node(int key, String data) {
    this.key   = key;
    this.data  = data;
    this.left  = null;
    this.right = null;
  }

  @Override
  public String toString() {
    return this.key + " has data: " + this.data;
  }
}

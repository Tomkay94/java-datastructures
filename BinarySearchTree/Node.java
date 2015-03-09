
/* Acts as a single node in a Binary Search Tree */

public class Node<T> {

  protected Node left;
  protected Node right;
  protected int key;
  protected T data;

  public Node(int key, T data) {
    this.key   = key;
    this.data  = data;
    this.left  = null;
    this.right = null;
  }

  @Override
  public String toString() {
    return ("Key: " + this.key + "| Data: " + this.data);
  }
}

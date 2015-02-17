
public class BinarySearchTree {

  private BSTNode root;

  public BinarySearchTree() {
    root = null;
  }

  protected void insert(int value) {
    if (root == null) {
      root = new BSTNode(value);
      return;
    }

    else {
      return root.add(value);
    }
  }

  protected BSTNode delete(int value) {

  }

}

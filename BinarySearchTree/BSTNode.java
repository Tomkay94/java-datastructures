
public class BSTNode {

  private BSTNode leftChild;
  private BSTNode rightChild;
  private int data;

  public BSTNode(int d) {
    this.data = d;
    this.leftChild = null;
    this.rightChild = null;
  }

  /* Add the node to the binary subtree tree. */
  /* Time complexity: O(n logn)*/
  protected void add(int value) {
    /* No duplicates allowed */
    if (value == this.value) {
      return;
    }

    /* Search the left subtree */
    else if (value < this.value) {
      /* Found a place to store the node */
      if (this.leftChild == null) {
        this.leftChild = new BSTNode(value);
        return;
      }

      /* Keep searching left */
      else  {
        return this.left.add(value);
      }
    }

    /* Search the right subtree */
    else if (value > this.value) {

      /* Found a place to store the node */
      if (this.rightChild == null) {
        this.right = new BSTNode(value);
        return;
      }

      /* Keep searching right */
      else {
        return this.right.add(value);
      }
    }
    return;
  }

  protected void remove(int value) {

  }

  protected BSTNode search(int value) {

  }

}

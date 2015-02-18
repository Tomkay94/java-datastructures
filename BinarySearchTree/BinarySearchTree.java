
/* Implements the Binary Search Tree data structure. */

public class BinarySearchTree {

  private Node root;

  public BinarySearchTree() {
    root = null;
  }

  /* Insert a node with key and data into the binary tree */
  protected void insert(int key, String data) {
    Node newNode = new Node(key, data);

    /* First node in the tree */
    if (root == null) {
      root = newNode;
      return;
    }

    /* Figure out where to put the newNode*/
    else {
      Node focusNode = root;
      Node parent;

      while(true) {
        parent = focusNode;

        /* newNode goes on the left subtree */
        if (key < focusNode.key) {
          focusNode = focusNode.leftChild;

          if (focusNode == null) {
            parent.leftChild = newNode;
            return;
          }
        }

        /* newNode goes on the right subtree */
        else if (key > focusNode.key) {
          focusNode = focusNode.rightChild;

          if (focusNode == null) {
            parent.rightChild = newNode;
            return;
          }
        }
      }
    }
  }

  /* Return the node with key in the binary tree.
  Return null if the key is not in the binary tree. */
  protected Node findNode(int key) {
    Node focusNode = root;

    while (focusNode.key != key) {
      if (key < focusNode.key) {
        /* Shift the focusNode left */
        focusNode = focusNode.leftChild;
      }

      else if (key > focusNode.key){
        /* Shift the focusNode right */
        focusNode = focusNode.rightChild;
      }

      if (focusNode == null) {
        return null;
      }
    }
    return focusNode;
  }

  /* Perform an in-order traversal on the binary tree. */
  protected void traverseInOrder(Node focusNode) {
    if (focusNode != null) {
      traverseInOrder(focusNode.leftChild);
      System.out.println(focusNode);
      traverseInOrder(focusNode.rightChild);
    }
    return;
  }

  /* Perform a pre-order traversal on the binary tree. */
  protected void traversePreOrder(Node focusNode) {
    if (focusNode != null) {
      System.out.println(focusNode);
      traversePreOrder(focusNode.leftChild);
      traversePreOrder(focusNode.rightChild);
    }
    return;
  }

  /* Perform a post-order traversal on the binary tree. */
  protected void traversePostOrder(Node focusNode) {
    if (focusNode != null) {
      traversePostOrder(focusNode.leftChild);
      traversePostOrder(focusNode.rightChild);
      System.out.println(focusNode);
    }
    return;
  }

}

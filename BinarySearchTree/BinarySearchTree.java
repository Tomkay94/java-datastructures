
/* Implements the Binary Search Tree data structure. */

public class BinarySearchTree<T> {

  protected Node root;

  public BinarySearchTree() {
    root = null;
  }

  /* Insert a node with key and data into the binary tree */
  protected void insert(int key, T data) {
    Node<T> newNode = new Node<T>(key, data);

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
          focusNode = focusNode.left;

          if (focusNode == null) {
            parent.left = newNode;
            return;
          }
        }

        /* newNode goes on the right subtree */
        else if (key > focusNode.key) {
          focusNode = focusNode.right;

          if (focusNode == null) {
            parent.right = newNode;
            return;
          }
        }
      }
    }
  }

  /* Return true if the key was removed */
  protected boolean remove(int key) {
    Node focusNode = root;
    Node parent    = root;

    boolean isLeftChild = true;

    /* First, find the node */
    while(focusNode.key != key) {
      parent = focusNode;

      if (key < focusNode.key) {
        isLeftChild = true;
        focusNode = focusNode.left;
      }

      else if (key > focusNode.key) {
        isLeftChild = false;
        focusNode = focusNode.right;
      }

      else if (focusNode == null) {
        return false;
      }
    }

    /* If the found node has no children */
    if (focusNode.left == null && focusNode.right == null) {
      /* Deleting the root. */
      if (focusNode == root) {
        root = null;
      }

      else if (isLeftChild) {
        parent.left = null;
      }

      else {
        parent.right = null;
      }
    }

    /* If the found node has no right child */
    else if (focusNode.right == null) {
      if (focusNode == root) {
        root = focusNode.left;
      }

      else if (isLeftChild) {
        parent.left = focusNode.left;
      }

      else {
        parent.right = focusNode.left;
      }
    }

    /* The found node has no left child */
    else if (focusNode.left == null) {
      if (focusNode == root) {
        root = focusNode.right;
      }

      else if (isLeftChild) {
        parent.left = focusNode.right;
      }

      else {
        parent.right = focusNode.left;
      }
    }

    /* The found node has two children */
    else {
      Node replacementNode = getReplacementNode(focusNode);

      if (focusNode == root) {
        root = replacementNode;
      }

      else if (isLeftChild) {
        parent.left = replacementNode;
      }

      else {
        parent.right = replacementNode;
      }

      replacementNode.left = focusNode.left;
    }

    /* The node was successfully deleted */
    return true;
  }

  /* Finds the node that replaces replacedNode
  for a binary search tree deletion. */
  private Node getReplacementNode(Node replacedNode) {
    Node replacementParent = replacedNode;
    Node replacement       = replacedNode;
    Node focusNode         = replacedNode.right;

    while(focusNode != null) {
      replacementParent = replacement;
      replacement       = focusNode;
      focusNode         = focusNode.left;
    }

    if (replacement != replacedNode.right) {
      replacementParent.left = replacement.right;
      replacement.right      = replacedNode.right;
    }

    return replacement;
  }

  /* Return the node with key in the binary tree.
  Return null if the key is not in the binary tree. */
  protected Node findNode(int key) {
    Node focusNode = root;

    while (focusNode.key != key) {
      if (key < focusNode.key) {
        /* Shift the focusNode left */
        focusNode = focusNode.left;
      }

      else if (key > focusNode.key){
        /* Shift the focusNode right */
        focusNode = focusNode.right;
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
      traverseInOrder(focusNode.left);
      System.out.println(focusNode);
      traverseInOrder(focusNode.right);
    }
    return;
  }

  /* Perform a pre-order traversal on the binary tree. */
  protected void traversePreOrder(Node focusNode) {
    if (focusNode != null) {
      System.out.println(focusNode);
      traversePreOrder(focusNode.left);
      traversePreOrder(focusNode.right);
    }
    return;
  }

  /* Perform a post-order traversal on the binary tree. */
  protected void traversePostOrder(Node focusNode) {
    if (focusNode != null) {
      traversePostOrder(focusNode.left);
      traversePostOrder(focusNode.right);
      System.out.println(focusNode);
    }
    return;
  }

  /* Determine if the binary tree is balanced. */
  protected boolean isBalanced(Node root) {
    if(checkHeight(root) == -1) {
      return false;
    }

    else {
      return true;
    }
  }

  /* Check binary tree level heights */
  private int checkHeight(Node root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = checkHeight(root.left);
    if (leftHeight == -1) {
      return -1;
    }

    int rightHeight = checkHeight(root.right);
    if (rightHeight == -1) {
      return -1;
    }

    int heightDiff = Math.abs(leftHeight - rightHeight);
    if (heightDiff > 1) {
      return -1;
    }

    else {
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  /* Determine if a given binary tree is also a binary search tree.*/
  protected boolean isBST(Node root) {
    return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  /* Determine whether node's subtrees fulfill
  the binary search tree properties. */
  private boolean checkBST(Node node, int MIN, int MAX) {
    if (node == null) {
      return true;
    }

    if (node.key > MIN &&
        node.key < MAX &&
        checkBST(node.left, MIN, Math.min(node.key, MAX)) &&
        checkBST(node.right, Math.max(node.key, MIN), MAX)) {
          return true;
        }
        else {
          return false;
        }
  }
}

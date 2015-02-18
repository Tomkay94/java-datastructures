import org.junit.*;

public class BinarySearchTreeTest {

  BinarySearchTree bst;

  @Before
  public void setUp() {
    bst = new BinarySearchTree();
  }

  @After
  public void tearDown() {
    bst = null;
  }

  @Test
  public void testFindExistingNode() {
    bst.insert(50, "Toronto");
    bst.insert(75, "New York");
    bst.insert(20, "Madrid");
    bst.insert(30, "Seattle");
    bst.insert(70, "Washington");
    Node foundNode = bst.findNode(70);

    Assert.assertEquals(foundNode.key, 70);
  }

  @Test
  public void testFindNonExistingNode() {
    bst.insert(50, "Toronto");
    bst.insert(75, "New York");
    bst.insert(20, "Madrid");
    bst.insert(30, "Seattle");
    bst.insert(70, "Washington");
    Node foundNode = bst.findNode(65);

    Assert.assertEquals(foundNode, null);
  }

  @Test
  public void testInsertIntoEmptyBST() {
    bst.insert(50, "Toronto");

    Assert.assertEquals(bst.root.data, "Toronto");
  }

  @Test
  public void testInsertRootLeftChild() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Waterloo");

    Assert.assertEquals(bst.root.left.key, 25);
  }

  @Test
  public void testInsertSubtreeLeftChild() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Waterloo");
    bst.insert(75, "New York");
    bst.insert(70, "Washington");
    bst.insert(85, "Copenhagen");

    Node foundNode = bst.findNode(75);

    Assert.assertEquals(foundNode.left.key, 70);
  }

  @Test
  public void testInsertSubtreeRightChild() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Waterloo");
    bst.insert(75, "New York");
    bst.insert(70, "Washington");
    bst.insert(85, "Copenhagen");

    Node foundNode = bst.findNode(75);

    Assert.assertEquals(foundNode.right.key, 85);
  }

  @Test
  public void testInsertRootRightChild() {
    bst.insert(50, "Toronto");
    bst.insert(75, "Waterloo");

    Assert.assertEquals(bst.root.right.key, 75);
  }

  @Test
  public void testRemoveRoot() {
    bst.insert(50, "Toronto");
    bst.remove(50);

    Assert.assertEquals(bst.root, null);
  }

  @Test
  public void testRemoveRootRightChild() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Waterloo");
    bst.insert(75, "New York");
    bst.remove(75);

    Assert.assertEquals(bst.root.right, null);
  }

  @Test
  public void testRemoveRootLeftChild() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Waterloo");
    bst.insert(75, "New York");
    bst.remove(25);

    Assert.assertEquals(bst.root.left, null);
  }

  @Test
  public void testRemoveParentWithNoChildren() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Waterloo");
    bst.insert(75, "New York");
    bst.insert(20, "Madrid");
    bst.insert(30, "Seattle");
    bst.remove(75);

    Node foundNode = bst.findNode(50);

    Assert.assertEquals(foundNode.right, null);
  }

  @Test
  public void testRemoveParentWithLeftChild() {
    bst.insert(50, "Toronto");
    bst.insert(75, "New York");
    bst.insert(20, "Madrid");
    bst.insert(30, "Seattle");
    bst.insert(70, "Washington");
    bst.remove(75);

    Node foundNode = bst.findNode(50);

    Assert.assertEquals(foundNode.right.key, 70);
  }

  @Test
  public void testRemoveParentWithRightChild() {
    bst.insert(50, "Toronto");
    bst.insert(75, "New York");
    bst.insert(85, "Copenhagen");
    bst.insert(20, "Madrid");
    bst.insert(30, "Seattle");
    bst.insert(70, "Washington");
    bst.remove(75);

    Node foundNode = bst.findNode(50);

    Assert.assertEquals(foundNode.right.key, 85);
  }

  @Test
  public void testRemoveParentWithBothChildren() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Waterloo");
    bst.insert(75, "New York");
    bst.insert(70, "Washington");
    bst.insert(85, "Copenhagen");
    bst.insert(20, "Madrid");
    bst.insert(30, "Seattle");

    Node foundNode = bst.findNode(75);

    Assert.assertEquals(foundNode.right.key, 85);
  }

  @Test
  public void testIsBalancedHeavyLeftSubtree() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Madrid");
    bst.insert(20, "Copenhagen");
    bst.insert(30, "Moscow");

    Assert.assertFalse(bst.isBalanced(bst.root));
  }

  @Test
  public void testIsBalancedHeavyRightSubtree() {
    bst.insert(50, "Toronto");
    bst.insert(75, "Waterloo");
    bst.insert(70, "New York");
    bst.insert(85, "Seattle");

    Assert.assertFalse(bst.isBalanced(bst.root));
  }

  @Test
  public void testIsBalancedFullSubtrees() {
    bst.insert(50, "Toronto");
    bst.insert(75, "Waterloo");
    bst.insert(70, "New York");
    bst.insert(85, "Seattle");
    bst.insert(25, "Madrid");
    bst.insert(20, "Copenhagen");
    bst.insert(30, "Moscow");

    Assert.assertTrue(bst.isBalanced(bst.root));
  }

  @Test
  public void testIsBalancedOneNode() {
    bst.insert(50, "Toronto");

    Assert.assertTrue(bst.isBalanced(bst.root));
  }

  @Test
  public void testIsBalancedRoot() {

    Assert.assertTrue(bst.isBalanced(bst.root));
  }

  @Test
  public void testIsBST() {
    bst.insert(50, "Toronto");
    bst.insert(75, "Waterloo");
    bst.insert(70, "New York");
    bst.insert(85, "Seattle");
    bst.insert(25, "Madrid");
    bst.insert(20, "Copenhagen");
    bst.insert(30, "Moscow");

    Assert.assertTrue(bst.isBST(bst.root));
  }
}

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

    Assert.assertEquals(bst.root.leftChild.key, 25);
  }

  @Test
  public void testInsertSubtreeLeftChild() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Waterloo");
    bst.insert(75, "New York");
    bst.insert(70, "Washington");
    bst.insert(85, "Copenhagen");

    Node foundNode = bst.findNode(75);

    Assert.assertEquals(foundNode.leftChild.key, 70);
  }

  @Test
  public void testInsertSubtreeRightChild() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Waterloo");
    bst.insert(75, "New York");
    bst.insert(70, "Washington");
    bst.insert(85, "Copenhagen");

    Node foundNode = bst.findNode(75);

    Assert.assertEquals(foundNode.rightChild.key, 85);
  }

  @Test
  public void testInsertRootRightChild() {
    bst.insert(50, "Toronto");
    bst.insert(75, "Waterloo");

    Assert.assertEquals(bst.root.rightChild.key, 75);
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

    Assert.assertEquals(bst.root.rightChild, null);
  }

  @Test
  public void testRemoveRootLeftChild() {
    bst.insert(50, "Toronto");
    bst.insert(25, "Waterloo");
    bst.insert(75, "New York");
    bst.remove(25);

    Assert.assertEquals(bst.root.leftChild, null);
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

    Assert.assertEquals(foundNode.rightChild, null);
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

    Assert.assertEquals(foundNode.rightChild.key, 70);
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

    Assert.assertEquals(foundNode.rightChild.key, 85);
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

    Assert.assertEquals(foundNode.rightChild.key, 85);
  }
}

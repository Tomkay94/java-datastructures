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
  public void testInsertIntoEmptyBST() {
    bst.insert(50, "Toronto");

    Assert.assertEquals(bst.root.data, "Toronto");
  }
}

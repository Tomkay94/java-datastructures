import static org.junit.Assert.*;
import org.junit.*;

public class AdjacencyListTest {

  Graph<Integer> g;

  @Before
  public void setUp() {
    g = new Graph<Integer>();
  }

  @After
  public void tearDown() {
    g = null;
  }

  @Test
  public void testNodeInit() {
    Node<Integer> head = new Node<Integer>(5);

    assertNotNull(head);
    assertNotNull(head.data);
    assertEquals(head.data, Integer.valueOf(5));
    assertNull(head.next);
  }

  /*****************************************/
  /************* Node Tests ****************/
  /*****************************************/
  @Test
  public void testAppendNodeOnce() {
    Node<Integer> head = new Node<Integer>(5);
    Node<Integer> tail = new Node<Integer>(10);

    head.appendHorizontal(tail);

    assertNotNull(head.next);
    assertNull(tail.next);
    assertEquals(head.next, tail);
    assertEquals(head.next.data, Integer.valueOf(10));
  }

  @Test
  public void testChainOfNodes() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);
    Node<Integer> tail  = new Node<Integer>(20);

    /* Assert all references are independent. */
    assertNull(head.next);
    assertNull(node1.next);
    assertNull(node2.next);
    assertNull(tail.next);

    head.appendHorizontal(node1);
    head.appendHorizontal(node2);
    head.appendHorizontal(tail);

    /* Assert references are correct. */
    assertNotNull(head.next);
    assertNotNull(node1.next);
    assertNotNull(node2.next);
    assertNull(tail.next);

    /* Assert their contents are correct. */
    assertEquals(head.data, Integer.valueOf(5));
    assertEquals(head.next.data, Integer.valueOf(10));
    assertEquals(node1.next.data, Integer.valueOf(15));
    assertEquals(node2.next.data, Integer.valueOf(20));
    assertEquals(tail.data, Integer.valueOf(20));
  }

  @Test
  public void testhasHorizontalTrue() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendHorizontal(node1);
    head.appendHorizontal(node2);
    assertTrue(head.hasHorizontal(10));
  }

  @Test
  public void testhasHorizontalFalse() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendHorizontal(node1);
    head.appendHorizontal(node2);
    assertFalse(head.hasHorizontal(20));
  }

  @Test
  public void testhasHorizontalAfterInsert() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendHorizontal(node1);
    assertFalse(head.hasHorizontal(15));
    head.appendHorizontal(node2);
    assertTrue(head.hasHorizontal(15));
  }

  @Test
  public void testNodeNotExistsAfterRemove() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendHorizontal(node1);
    head.appendHorizontal(node2);
    assertTrue(head.hasHorizontal(10));

    /* Point head to the list with the removed node. */
    head = head.remove(head, 10);
    assertFalse(head.hasHorizontal(10));
  }

  @Test
  public void testhasHorizontalFirstNode() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendHorizontal(node1);
    head.appendHorizontal(node2);
    assertTrue(head.hasHorizontal(5));
  }

  @Test
  public void testhasHorizontalLastNode() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendHorizontal(node1);
    head.appendHorizontal(node2);
    assertTrue(head.hasHorizontal(10));
  }

  @Test
  public void testDeleteFirstNode() {
    Node<Integer> head  = new Node<Integer>(10);
    Node<Integer> node1 = new Node<Integer>(15);
    Node<Integer> node2 = new Node<Integer>(20);

    head.appendHorizontal(node1);
    head.appendHorizontal(node2);
    head = head.remove(head, head.data);

    assertEquals(head, node1);
    assertFalse(head.hasHorizontal(10));
  }

  @Test
  public void testDeleteLastNode() {
    Node<Integer> head  = new Node<Integer>(10);
    Node<Integer> node1 = new Node<Integer>(25);
    Node<Integer> node2 = new Node<Integer>(30);

    head.appendHorizontal(node1);
    head.appendHorizontal(node2);

    head = head.remove(head, node2.data);

    assertEquals(node1.next, null);
    assertFalse(head.hasHorizontal(30));
  }

  /*****************************************/
  /********** Graph Tests **********/
  /*****************************************/
  @Test
  public void testAdjListConstructor() {
    assertNotNull(g);

    assertEquals(g.getNumEdges(), 0);
  }

  @Test
  public void testHasDirectedEdgeOnly() {
    g.addDirectedEdge(1, 2);
    g.addDirectedEdge(1, 3);
    g.addDirectedEdge(2, 3);
    g.addDirectedEdge(3, 4);

    assertTrue(g.hasDirectedEdge(1, 3));
    assertFalse(g.hasDirectedEdge(3, 1));
  }

  @Test
  public void testHasNoDirectedEdge() {
    g.addDirectedEdge(1, 2);
    g.addDirectedEdge(1, 3);
    g.addDirectedEdge(2, 3);
    g.addDirectedEdge(3, 4);

    assertFalse(g.hasDirectedEdge(1, 4));
  }

  @Test
  public void testHasUndirectedEdgeOnly() {
    g.addDirectedEdge(1, 2);
    g.addDirectedEdge(1, 3);
    g.addDirectedEdge(2, 1);
    g.addDirectedEdge(3, 4);

    assertTrue(g.hasUndirectedEdge(1, 2));
    assertTrue(g.hasUndirectedEdge(2, 1));
  }

  @Test
  public void testHasNoUndirectedEdge() {
    g.addDirectedEdge(1, 2);
    g.addDirectedEdge(1, 3);
    g.addDirectedEdge(2, 1);
    g.addDirectedEdge(3, 4);

    assertFalse(g.hasUndirectedEdge(1, 3));
  }

  @Test
  public void testAddDirectedEdges() {
    assertEquals(g.getNumEdges(), 0);

    g.addDirectedEdge(1, 2);
    assertEquals(g.getNumEdges(), 1);
    assertTrue(g.hasDirectedEdge(1, 2));

    g.addDirectedEdge(1, 3);
    assertEquals(g.getNumEdges(), 2);
    assertTrue(g.hasDirectedEdge(1, 3));

    g.addDirectedEdge(3, 4);
    assertEquals(g.getNumEdges(), 3);
    assertTrue(g.hasDirectedEdge(3, 4));
  }

  @Test
  public void testAddUndirectedEdgesOnly() {
    assertEquals(g.getNumEdges(), 0);

    g.addUndirectedEdge(1, 2);
    assertEquals(g.getNumEdges(), 2);
    assertTrue(g.hasUndirectedEdge(1, 2));

    g.addUndirectedEdge(1, 3);
    assertEquals(g.getNumEdges(), 4);
    assertTrue(g.hasUndirectedEdge(1, 3));

    g.addUndirectedEdge(3, 4);
    assertEquals(g.getNumEdges(), 6);
    assertTrue(g.hasUndirectedEdge(3, 4));
  }
}

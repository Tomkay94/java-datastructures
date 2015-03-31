import static org.junit.Assert.*;
import org.junit.*;

public class AdjacencyListTest {

  AdjacencyList<Integer> adjList;

  @Before
  public void setUp() {
    adjList = new AdjacencyList<Integer>();
  }

  @After
  public void tearDown() {
    adjList = null;
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

    head.appendToTail(tail);

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

    head.appendToTail(node1);
    head.appendToTail(node2);
    head.appendToTail(tail);

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
  public void testnodeWithDataExistsTrue() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    head.appendToTail(node2);
    assertTrue(head.nodeWithDataExists(10));
  }

  @Test
  public void testnodeWithDataExistsFalse() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    head.appendToTail(node2);
    assertFalse(head.nodeWithDataExists(20));
  }

  @Test
  public void testnodeWithDataExistsAfterInsert() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    assertFalse(head.nodeWithDataExists(15));
    head.appendToTail(node2);
    assertTrue(head.nodeWithDataExists(15));
  }

  @Test
  public void testNodeNotExistsAfterRemove() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    head.appendToTail(node2);
    assertTrue(head.nodeWithDataExists(10));

    /* Point head to the list with the removed node. */
    head = head.remove(head, 10);
    assertFalse(head.nodeWithDataExists(10));
  }

  @Test
  public void testnodeWithDataExistsFirstNode() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    head.appendToTail(node2);
    assertTrue(head.nodeWithDataExists(5));
  }

  @Test
  public void testnodeWithDataExistsLastNode() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    head.appendToTail(node2);
    assertTrue(head.nodeWithDataExists(10));
  }

  @Test
  public void testDeleteFirstNode() {
    Node<Integer> head  = new Node<Integer>(10);
    Node<Integer> node1 = new Node<Integer>(15);
    Node<Integer> node2 = new Node<Integer>(20);

    head.appendToTail(node1);
    head.appendToTail(node2);
    head = head.remove(head, head.data);

    assertEquals(head, node1);
    assertFalse(head.nodeWithDataExists(10));
  }

  @Test
  public void testDeleteLastNode() {
    Node<Integer> head  = new Node<Integer>(10);
    Node<Integer> node1 = new Node<Integer>(25);
    Node<Integer> node2 = new Node<Integer>(30);

    head.appendToTail(node1);
    head.appendToTail(node2);

    head = head.remove(head, node2.data);

    assertEquals(node1.next, null);
    assertFalse(head.nodeWithDataExists(30));
  }

  /*****************************************/
  /********** AdjacencyList Tests **********/
  /*****************************************/
  @Test
  public void testAdjListConstructor() {
    assertNotNull(adjList);
    assertEquals(adjList.getNumEdges(), 0);
  }

  @Test
  public void testHasDirectedEdgeOnly() {
    adjList.addDirectedEdge(1, 2);
    adjList.addDirectedEdge(1, 3);
    adjList.addDirectedEdge(2, 3);
    adjList.addDirectedEdge(3, 4);
    assertTrue(adjList.hasDirectedEdge(1, 3));
    assertFalse(adjList.hasDirectedEdge(3, 1));
  }

  @Test
  public void testHasDirectedEdgeNone() {
    adjList.addDirectedEdge(1, 2);
    adjList.addDirectedEdge(1, 3);
    adjList.addDirectedEdge(2, 3);
    adjList.addDirectedEdge(3, 4);
    assertFalse(adjList.hasDirectedEdge(1, 4));
  }
}

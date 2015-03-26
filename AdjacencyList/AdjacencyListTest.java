import static org.junit.Assert.*;
import org.junit.*;

public class AdjacencyListTest {

  AdjacencyList adjList;

  @Before
  public void setUp() {
    adjList = new AdjacencyList<Integer>(5);
  }

  @After
  public void tearDown() {
    adjList = null;
  }

  @Test
  public void testAdjListConstructor() {
    assertNotNull(adjList);
  }

  @Test
  public void testNodeInit() {
    Node<Integer> head = new Node<Integer>(5);

    assertNotNull(head);
    assertNotNull(head.data);
    assertEquals(head.data, Integer.valueOf(5));
    assertNull(head.next);
  }

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
  public void testNodeExistsTrue() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    head.appendToTail(node2);
    assertTrue(head.nodeExists(10));
  }

  @Test
  public void testNodeExistsFalse() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    head.appendToTail(node2);
    assertFalse(head.nodeExists(20));
  }

  @Test
  public void testNodeExistsAfterInsert() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    assertFalse(head.nodeExists(15));
    head.appendToTail(node2);
    assertTrue(head.nodeExists(15));
  }

  @Test
  public void testNodeNotExistsAfterRemove() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    head.appendToTail(node2);
    assertTrue(head.nodeExists(10));

    /* Point head to the list with the removed node. */
    head = head.remove(head, 10);
    assertFalse(head.nodeExists(10));
  }

  @Test
  public void testNodeExistsFirstNode() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    head.appendToTail(node2);
    assertTrue(head.nodeExists(5));
  }

  @Test
  public void testNodeExistsLastNode() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);

    head.appendToTail(node1);
    head.appendToTail(node2);
    assertTrue(head.nodeExists(10));
  }
}

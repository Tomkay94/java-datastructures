import static org.junit.Assert.*;
import org.junit.*;

public class GraphTest {

  GraphAdjacencyMatrix adjMat;
  GraphAdjacencyList   adjList;

  @Before
  public void setUp() {
    adjMat  = new GraphAdjacencyMatrix(5);
    adjList = new GraphAdjacencyList<Integer>(5);
  }

  @After
  public void tearDown() {
    adjMat  = null;
    adjList = null;
  }

  @Test
  public void testAdjMatrixConstructor() {
    assertNotNull(adjMat);
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
}

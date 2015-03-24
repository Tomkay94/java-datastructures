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
}

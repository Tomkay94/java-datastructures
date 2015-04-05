import static org.junit.Assert.*;
import org.junit.*;

public class QueueTest {

  Queue<Integer> q;

  @Before
  public void setUp() {
    q = new Queue<Integer>();
  }

  @After
  public void tearDown() {
    q = null;
  }

  @Test
  public void testQueueConstructor() {
    assertEquals(q.getSize(), 0);
    assertNull(q.getHead());
    assertNull(q.getTail());
  }

  @Test
  public void testIsEmptyOnEmpty() {
    assertEquals(q.getSize(), 0);
    assertTrue(q.isEmpty());
  }

  @Test
  public void testEnqueueOnEmpty() {
    q.enqueue(5);

    assertEquals(q.getSize(), 1);
  }

  @Test
  public void testDequeueOnEmpty() {
    Node<Integer> wasRemoved = q.dequeue();

    assertNull(wasRemoved);
  }

  @Test
  public void testEnqueueKeepsOrder() {
    q.enqueue(5);
    q.enqueue(15);
    q.enqueue(25);
    q.enqueue(35);

    assertEquals(q.dequeue().data, (Integer) 5);
    assertEquals(q.dequeue().data, (Integer) 15);
    assertEquals(q.dequeue().data, (Integer) 25);
    assertEquals(q.dequeue().data, (Integer) 35);
  }

  @Test
  public void testDequeueKeepsOrder() {
    Node<Integer> item1 = new Node<Integer>(5);
    Node<Integer> item2 = new Node<Integer>(15);
    Node<Integer> item3 = new Node<Integer>(25);
    Node<Integer> item4 = new Node<Integer>(35);

    q.enqueue(item1.data);
    q.enqueue(item2.data);
    q.enqueue(item3.data);
    q.enqueue(item4.data);

    assertEquals(q.dequeue().data, item1.data);
    assertEquals(q.dequeue().data, item2.data);
    assertEquals(q.dequeue().data, item3.data);
    assertEquals(q.dequeue().data, item4.data);
  }

  @Test
  public void testEnqueueUpdatesSize() {
    q.enqueue(5);
    assertEquals(q.getSize(), 1);

    q.enqueue(15);
    assertEquals(q.getSize(), 2);

    q.enqueue(25);
    assertEquals(q.getSize(), 3);

    q.enqueue(35);
    assertEquals(q.getSize(), 4);
  }

  @Test
  public void testDequeueUpdatesSize() {
    q.enqueue(5);
    q.enqueue(15);
    q.enqueue(25);
    q.enqueue(35);

    assertEquals(q.getSize(), 4);

    assertEquals(q.dequeue().data, (Integer) 5);
    assertEquals(q.getSize(), 3);

    assertEquals(q.dequeue().data, (Integer) 15);
    assertEquals(q.getSize(), 2);

    assertEquals(q.dequeue().data, (Integer) 25);
    assertEquals(q.getSize(), 1);

    assertEquals(q.dequeue().data, (Integer) 35);
    assertEquals(q.getSize(), 0);
  }
}

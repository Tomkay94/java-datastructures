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
  public void testDequeueOnEmptyFails() {
    Node<Integer> wasRemoved = q.dequeue();

    assertNull(wasRemoved);
  }
}

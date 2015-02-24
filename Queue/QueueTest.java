import static org.junit.Assert.*;
import org.junit.*;

public class QueueTest {

  Queue<Integer> q;

  @Before
  public void setUp() {
    q = new Queue<Integer>(5);
  }

  @After
  public void tearDown() {
    q = null;
  }

  @Test
  public void testQueueConstructor() {
    assertEquals(q.getSize(), 0);
  }

  @Test
  public void testIsEmptyOnEmpty() {

    assertTrue(q.isEmpty());
  }

  @Test
  public void testEnqueueOnEmpty() {
    q.enqueue(5);

    assertEquals(q.getSize(), 1);
  }

  @Test
  public void testEnqueueOnFullCapacityFails() {
    q.enqueue(5);
    q.enqueue(4);
    q.enqueue(3);
    q.enqueue(2);
    q.enqueue(1);

    boolean isQueued = q.enqueue(0);

    assertFalse(isQueued);
  }

  @Test
  public void testDequeueOnEmptyFails() {
    Integer removed = q.dequeue();

    assertEquals(removed, null);
  }

  @Test
  public void testDequeueOnFull() {
    q.enqueue(5);
    q.enqueue(4);
    q.enqueue(3);
    q.enqueue(2);
    q.enqueue(1);

    Integer removed = q.dequeue();

    assertEquals(removed, Integer.valueOf(5));
  }

}

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
    assertEqual(q.);
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
  public void testDequeueOnEmptyFails() {
    Integer wasRemoved = q.dequeue();

    assertNull(wasRemoved);
  }
}

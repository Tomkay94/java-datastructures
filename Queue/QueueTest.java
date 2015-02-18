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
  public void testIsEmptyOnEmpty() {

    Assert.assertTrue(q.isEmpty());
  }

  @Test
  public void testEnqueueOnEmpty() {
    q.enqueue(5);

    Assert.assertEquals(q.size, 1);
  }

  @Test
  public void testEnqueueOnFullCapacityFails() {
    q.enqueue(5);
    q.enqueue(4);
    q.enqueue(3);
    q.enqueue(2);
    q.enqueue(1);

    boolean isQueued = q.enqueue(0);

    Assert.assertFalse(isQueued);
  }

  @Test
  public void testDequeueOnEmptyFails() {
    Integer removed = q.dequeue();

    Assert.assertEquals(removed, null);
  }

}

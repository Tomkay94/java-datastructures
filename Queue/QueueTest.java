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
  public void testDequeueOnEmpty() {
    Integer removed = q.dequeue();

    Assert.assertEquals(removed, null);
  }

}

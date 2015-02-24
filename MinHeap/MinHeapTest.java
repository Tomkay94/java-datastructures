import static org.junit.Assert.*;
import org.junit.*;

public class MinHeapTest {

  MinHeap heap;

  @Before
  public void setUp() {
    heap = new MinHeap(5);
  }

  @After
  public void tearDown() {
    heap = null;
  }

  @Test
  public void testHeapConstructor() {
    assertEquals(heap.getSize(), 0);
    assertNotNull(heap.getHeapArray());
  }

  @Test
  public void testIsEmptyOnEmpty() {

    assertTrue(heap.isEmpty());
  }

  @Test
  public void testIsEmptyOnNonEmpty() {
    heap.insert(50);

    assertTrue(heap.isEmpty());
  }

  @Test
  public void testGetMinEmptyHeap() {

    assertEquals(heap.getMin(), -1);
  }
}

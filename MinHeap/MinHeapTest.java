import static org.junit.Assert.*;
import org.junit.*;

public class MinHeapTest {

  MinHeap heap;

  @Before
  public void setUp() {
    heap = new MinHeap(4);
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

    assertEquals(heap.getSize(), 0);
    assertTrue(heap.isEmpty());
  }

  @Test
  public void testIsEmptyOnNonEmpty() {
    heap.insert(5);

    assertTrue(heap.getSize() > 0);
    assertFalse(heap.isEmpty());
  }

  @Test
  public void testGetMinEmptyHeap() {

    assertTrue(heap.isEmpty());
    assertEquals(heap.getMin(), -1);
  }

  @Test
  public void testGetMinInsertedInOrder() {
    heap.insert(5);
    heap.insert(50);
    heap.insert(500);
    heap.insert(5000);

    assertEquals(heap.getMin(), 5);
  }

  @Test
  public void testGetMinInsertedUnsortedOrder() {
    heap.insert(500);
    heap.insert(50);
    heap.insert(5);
    heap.insert(5000);

    assertEquals(heap.getMin(), 5);
  }

  @Test
  public void testInsertUpdatesSize() {
    heap.insert(5);
    heap.insert(50);
    heap.insert(500);
    heap.insert(5000);

    assertEquals(heap.getSize(), 4);
  }

  @Test
  public void testGetRootLeftChildOnFullHeap() {
    heap.insert(5);
    heap.insert(50);
    heap.insert(500);
    heap.insert(5000);

    assertEquals(
      heap.getElementByIndex(heap.getLeftChildIndex(0))
      , 50
    );
  }

  @Test
  public void testGetRootRightChildOnFullHeap() {
    heap.insert(5);
    heap.insert(50);
    heap.insert(500);
    heap.insert(5000);

    assertEquals(
      heap.getElementByIndex(heap.getRightChildIndex(0))
      , 500
    );
  }

  @Test
  public void testGetParentOnFullHeap() {
    heap.insert(5);
    heap.insert(50);
    heap.insert(500);
    heap.insert(5000);

    assertEquals(
      heap.getElementByIndex(heap.getParentIndex(2))
      , 5
    );
  }
}

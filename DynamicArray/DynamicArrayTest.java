import static org.junit.Assert.*;
import org.junit.*;

public class DynamicArrayTest {

  DynamicArray da;

  @Before
  public void setUp() {
    /* Create an array that doubles in size when its capacity is reached. */
    da = new DynamicArray(3, 2);
  }

  @After
  public void tearDown() {
    da = null;
  }

  @Test
  public void testDynamicArrayConstructor() {
    assertNotNull(da);
    assertEquals(da.getSize(), 0);
  }

  @Test
  public void testArrayExpandsToFactor() {
    da.insert(10);
    da.insert(100);
    da.insert(1000);
    int oldCapacity = da.getCapacity();

    /* This insert will expand the array */
    da.insert(10000);
    int newCapacity = da.getCapacity();

    assertEquals(newCapacity, da.getResizeFactor() * oldCapacity);
    assertEquals(da.getCapacity(), 6);
  }

  @Test
  public void testArrayDoesNotExpand() {
    da.insert(10);
    da.insert(100);
    assertEquals(da.getCapacity(), 3);
  }

  @Test
  public void testInsertUpdatesSize() {
    da.insert(10);
    da.insert(100);
    assertEquals(da.getSize(), 2);
    assertEquals(da.getCapacity(), 3);
  }

  @Test
  public void testInsertFirstElement() {
    da.insert(10);

    assertTrue(da.hasElement(10));
    assertEquals(da.getSize(), 1);
    assertEquals(da.getCapacity(), 3);
  }

  @Test
  public void testInsertAddsElementToArray() {
    da.insert(10);
    da.insert(100);

    assertTrue(da.hasElement(10));
    assertTrue(da.hasElement(100));
    assertEquals(da.getSize(), 2);
    assertEquals(da.getCapacity(), 3);
  }

  @Test
  public void testRemoveUpdatesSize() {
    da.insert(10);
    da.insert(100);

    da.remove(1);
    assertEquals(da.getSize(), 1);
    assertEquals(da.getCapacity(), 3);
  }

  @Test
  public void testRemoveDeletesElementFromArray() {
    da.insert(10);
    da.insert(100);

    Integer elementRemoved = da.remove(1);
    assertEquals(elementRemoved, Integer.valueOf(100));
    assertEquals(da.getSize(), 1);
    assertEquals(da.getCapacity(), 3);
    assertFalse(da.hasElement(100));
  }
}

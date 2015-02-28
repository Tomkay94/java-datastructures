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
    da.insert(10);
    da.insert(10);
    da.insert(10);
    assertEquals(da.getCapacity(), 6);
  }

  @Test
  public void testArrayDoesNotExpand() {
    da.insert(10);
    da.insert(10);
    assertEquals(da.getCapacity(), 3);
  }

}

import static org.junit.Assert.*;
import org.junit.*;

public class DynamicArrayTest {

  DynamicArray da;

  @Before
  public void setUp() {
    /* Create an array that doubles in size when its capacity is reached. */
    da = new DynamicArray(5, 2);
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

}

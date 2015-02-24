import static org.junit.Assert.*;
import org.junit.*;

public class DynamicArrayTest {

  DynamicArray da;

  @Before
  public void setUp() {
    da = new DynamicArray<Integer>(5);
  }

  @After
  public void tearDown() {
    da = null;
  }

  @Test
  public void testDynamicArrayConstructor() {

  }

}

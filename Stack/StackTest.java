import static org.junit.Assert.*;
import org.junit.*;

public class StackTest {

  Stack<String> cities;

  @Before
  public void setUp() {
    cities = new Stack<String>(5);
  }

  @After
  public void tearDown() {
    cities = null;
  }

  @Test
  public void testPushOnEmpty() {
    boolean wasAdded = cities.push("Toronto");

    assertTrue(wasAdded);
  }

  @Test
  public void testPushOnEmptySizeUpdates() {
    cities.push("Toronto");

    assertEquals(cities.size, 1);
  }

  @Test
  public void testPushOnFull() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");

    /* Push past the capacity */
    boolean wasAdded = cities.push("Moscow");

    assertFalse(wasAdded);
  }

  @Test
  public void testPushOnFullSizeUnchanged() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");

    /* Push past the capacity, should fail. */
    cities.push("Moscow");

    assertEquals(cities.size, cities.capacity);
  }

  @Test
  public void testPushGoesToTopOfStack() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");

    String topItem = cities.pop();

    assertEquals(topItem, "Copenhagen");
  }

  @Test
  public void testPopOnEmptySizeUnchanged() {
    cities.pop();

    assertEquals(cities.size, 0);
  }

  @Test
  public void testPopOnEmptyReturnsFalse() {
    String poppedItem = cities.pop();

    assertEquals(poppedItem, null);
  }

  @Test
  public void testPopOnFull() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");
    cities.pop();

    assertEquals(cities.size, 4);
  }

  @Test
  public void testPopGetsTopItem() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");
    String poppedItem = cities.pop();

    assertEquals(poppedItem, "London");
  }

  @Test
  public void testPopGetsNullOnEmpty() {
    String poppedItem = cities.pop();

    assertEquals(poppedItem, null);
  }

  @Test
  public void testPopOnRegular() {
    cities.push("Toronto");
    cities.push("New York");
    cities.pop();

    assertEquals(cities.size, 1);
  }

  @Test
  public void testIsEmptyOnFull() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");

    assertFalse(cities.isEmpty());
  }

  @Test
  public void testIsEmptyOnEmpty() {
    assertTrue(cities.isEmpty());
  }

  @Test
  public void testHasCapacityOnEmpty() {
    assertTrue(cities.hasSpace());
  }

  @Test
  public void testHasCapacityOnFull() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");

    assertFalse(cities.hasSpace());
  }

  @Test
  public void testPeekTop() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");

    assertEquals(cities.peek(), "London");
  }
}

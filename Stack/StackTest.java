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

    Assert.assertTrue(wasAdded);
  }

  @Test
  public void testPushOnEmptySizeUpdates() {
    cities.push("Toronto");

    Assert.assertEquals(cities.size, 1);
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

    Assert.assertFalse(wasAdded);
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

    Assert.assertEquals(cities.size, cities.capacity);
  }

  @Test
  public void testPushGoesToTopOfStack() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");

    String topItem = cities.pop();

    Assert.assertEquals(topItem, "Copenhagen");
  }

  @Test
  public void testPopOnEmptySizeUnchanged() {
    cities.pop();

    Assert.assertEquals(cities.size, 0);
  }

  @Test
  public void testPopOnEmptyReturnsFalse() {
    String poppedItem = cities.pop();

    Assert.assertEquals(poppedItem, null);
  }

  @Test
  public void testPopOnFull() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");
    cities.pop();

    Assert.assertEquals(cities.size, 4);
  }

  @Test
  public void testPopGetsTopItem() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");
    String poppedItem = cities.pop();

    Assert.assertEquals(poppedItem, "London");
  }

  @Test
  public void testPopGetsNullOnEmpty() {
    String poppedItem = cities.pop();

    Assert.assertEquals(poppedItem, null);
  }

  @Test
  public void testPopOnRegular() {
    cities.push("Toronto");
    cities.push("New York");
    cities.pop();

    Assert.assertEquals(cities.size, 1);
  }

  @Test
  public void testIsEmptyOnFull() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");

    Assert.assertFalse(cities.isEmpty());
  }

  @Test
  public void testIsEmptyOnEmpty() {
    Assert.assertTrue(cities.isEmpty());
  }

  @Test
  public void testHasCapacityOnEmpty() {
    Assert.assertTrue(cities.hasSpace());
  }

  @Test
  public void testHasCapacityOnFull() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");

    Assert.assertFalse(cities.hasSpace());
  }

  @Test
  public void testPeekTop() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");

    Assert.assertEquals(cities.peek(), "London");
  }
}

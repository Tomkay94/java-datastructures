import static org.junit.Assert.*;
import org.junit.*;

public class StackTest {

  Stack<String> cities;

  @Before
  public void setUp() {
    cities = new Stack<String>();
  }

  @After
  public void tearDown() {
    cities = null;
  }

  @Test
  public void testStackConstructor() {
    assertEquals(cities.getSize(), 0);
  }

  @Test
  public void testPushOnEmpty() {
    assertEquals(cities.getSize(), 0);
    cities.push("Toronto");
    assertEquals(cities.getSize(), 1);
  }

  @Test
  public void testPushOnEmptySizeUpdates() {
    cities.push("Toronto");

    assertEquals(cities.getSize(), 1);
  }

  @Test
  public void testPushUpdatesSize() {
    cities.push("Toronto");
    assertEquals(cities.getSize(), 1);

    cities.push("New York");
    assertEquals(cities.getSize(), 2);

    cities.push("Copenhagen");
    assertEquals(cities.getSize(), 3);

    cities.push("Rome");
    assertEquals(cities.getSize(), 4);

    cities.push("London");
    assertEquals(cities.getSize(), 5);
  }

  @Test
  public void testPushGoesToTopOfStack() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");

    Node<String> topItem = cities.pop();

    assertEquals(topItem.data, "Copenhagen");
  }

  @Test
  public void testPopOnEmptySizeUnchanged() {
    cities.pop();

    assertEquals(cities.getSize(), 0);
  }

  @Test
  public void testPopOnEmptyReturnsFalse() {
    Node<String> poppedItem = cities.pop();

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

    assertEquals(cities.getSize(), 4);
  }

  @Test
  public void testPopGetsTopItem() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");
    Node<String> poppedItem = cities.pop();

    assertEquals(poppedItem.data, "London");
  }

  @Test
  public void testPopGetsNullOnEmpty() {
    Node<String> poppedItem = cities.pop();

    assertEquals(poppedItem, null);
  }

  @Test
  public void testPopOnRegular() {
    cities.push("Toronto");
    cities.push("New York");
    cities.pop();

    assertEquals(cities.getSize(), 1);
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
    assertEquals(cities.getSize(), 0);
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

  @Test
  public void testPeekDoesNotRemoveItem() {
    cities.push("Toronto");
    cities.push("New York");
    cities.push("Copenhagen");
    cities.push("Rome");
    cities.push("London");

    int sizeBeforePeek = cities.getSize();
    cities.peek();
    int sizeAfterPeek = cities.getSize();

    assertEquals(sizeBeforePeek, sizeAfterPeek);
  }
}

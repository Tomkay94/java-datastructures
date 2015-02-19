import org.junit.*;

public class HashMapTest {

  HashMap hm;

  @Before
  public void setUp() {
    hm = new HashMap(7);
  }

  @After
  public void tearDown() {
    hm = null;
  }

  @Test
  public void testMapSizeBecomesPrimeWhenInputEven() {
    HashMap mapEvenSize = new HashMap(4);

    Assert.assertEquals(mapEvenSize.size, 5);
  }

  @Test
  public void testMapSizeBecomesPrimeWhenInputOdd() {
    HashMap mapOddSize = new HashMap(15);

    Assert.assertEquals(mapOddSize.size, 17);
  }

  @Test
  public void testMapSizeRemainsPrimeWhenInputPrime() {
    HashMap mapPrimeSize = new HashMap(17);

    Assert.assertEquals(mapPrimeSize.size, 17);
  }

  @Test
  public void testInsertSingleKey() {
    hm.put("Toronto", 10);

    Assert.assertEquals(hm.getKey("Toronto"), Integer.valueOf(10));
  }

  @Test
  public void testInsertMaxIntValue() {
    hm.put("Toronto", Integer.MAX_VALUE);

    Assert.assertEquals(hm.getKey("Toronto"), Integer.valueOf(Integer.MAX_VALUE));
  }

  @Test
  public void testInsertDuplicatesOverwrite() {
    hm.put("New York", 15);
    hm.put("New York", 10);

    Assert.assertEquals(hm.getKey("New York"), Integer.valueOf(10));
  }

  @Test
  public void testGetKeyFindsKey() {
    hm.put("Toronto", 10);

    Assert.assertEquals(hm.getKey("Toronto"), Integer.valueOf(10));
  }

  @Test
  public void testGetInvalidKey() {

    Assert.assertNull(hm.getKey("Copenhagen"));
  }

  @Test
  public void testDeleteRemovesEntry() {
    hm.put("Toronto", 10);
    hm.delete("Toronto");

    Assert.assertNull(hm.getKey("Toronto"));
  }

  @Test
  public void testDeleteExistingEntry() {
    hm.put("Toronto", 10);
    boolean wasDeleted = hm.delete("Toronto");

    Assert.assertTrue(wasDeleted);
  }

  @Test
  public void testDeleteNonExistingEntry() {
    boolean wasDeleted = hm.delete("Toronto");

    Assert.assertFalse(wasDeleted);
  }

}

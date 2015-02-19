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
  public void testInsertSingleKey() {
    hm.put("Toronto", 10);

    Assert.assertEquals(hm.getKey("Toronto"), 10);
  }

  @Test
  public void testInsertDuplicateKeyUpdates() {
    hm.put("New York", 15);
    hm.put("New York", 10);

    Assert.assertEquals(hm.getKey("New York"), 10);
  }

  @Test
  public void testGetInvalidKey() {

    Assert.assertEquals(hm.getKey("Copenhagen"), -1);
  }

  @Test
  public void testHashSizeGetsNextPrime() {
    HashMap hmap = new HashMap(4);

    Assert.assertEquals(hmap.size, 5);
  }

  @Test
  public void testDeleteEntry() {
    hm.put("Toronto", 10);
    hm.delete("Toronto");

    Assert.assertEquals(hm.getKey("Toronto") , -1);
  }

}

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
  public void testInsertInvalidKey() {

    Assert.assertEquals(hm.getKey("Copenhagen"), -1);
  }

  @Test
  public void testHashSizeGetsNextPrime() {
    HashMap hmap = new HashMap(4);

    Assert.assertEquals(hmap.size, 5);
  }

}

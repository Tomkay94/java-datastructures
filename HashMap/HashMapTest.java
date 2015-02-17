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
    hm.put("someKey", 8);

    Assert.assertEquals(hm.getKey("someKey"), 8);
  }

  @Test
  public void testInsertDuplicateKeyUpdates() {
    hm.put("someKey", 8);
    hm.put("someKey", 10);

    Assert.assertEquals(hm.getKey("someKey"), 10);
  }

  @Test
  public void testInsertInvalidKey() {

    Assert.assertEquals(hm.getKey("someKey"), -1);
  }

}

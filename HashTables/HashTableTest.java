import org.junit.*;

public class HashTableTest {

  private HashTable ht;

  @Before
  public void init() {
    ht = new HashTable(17);
  }

  @After
  public void clear() {
    ht = null;
  }

  @Test
  public void testInsertEntry() {
    ht.hashFunctionMod("5");

    // Assert here
  }

  @Test
  public void testFindKeyLast() {
    ht.hashFunctionMod("35");
    ht.hashFunctionMod("40");
    ht.hashFunctionMod("45");
    ht.hashFunctionMod("50");
    ht.hashFunctionMod("55");

    // Assert here
  }

  @Test
  public void testFindKeyFirst() {
    ht.hashFunctionMod("35");
    ht.hashFunctionMod("40");
    ht.hashFunctionMod("45");
    ht.hashFunctionMod("50");
    ht.hashFunctionMod("55");

    // Assert here
  }

}

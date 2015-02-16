import org.junit.*;

public class HashTableTest {

  @Test
  public void testInsertEntry() {
    HashTable ht = new HashTable(17);
    ht.hashFunctionMod("5");
  }

  @Test
  public void testFindKeyLast() {
    HashTable ht = new HashTable(17);
    ht.hashFunctionMod("35");
    ht.hashFunctionMod("40");
    ht.hashFunctionMod("45");
    ht.hashFunctionMod("50");
    ht.hashFunctionMod("55");
  }

  @Test
  public void testFindKeyFirst() {
    HashTable ht = new HashTable(17);
    ht.hashFunctionMod("35");
    ht.hashFunctionMod("40");
    ht.hashFunctionMod("45");
    ht.hashFunctionMod("50");
    ht.hashFunctionMod("55");
  }

}

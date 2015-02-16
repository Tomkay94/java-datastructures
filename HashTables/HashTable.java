public class HashTable {

  String[] arrayTable;
  int arraySize;

  public HashTable(int size) {
    this.arraySize = size;
    this.arrayTable = new String[size];
  }

  /* Simple (and bad) hash function. Maps values to same index for that value. */
  protected void hashFunctionIndex(String newElementVal) {
    this.arrayTable[Integer.parseInt(newElementVal)] = newElementVal;

    System.out.println(
      "arrayTable"+ "[" + Integer.parseInt(newElementVal) +"]: "
      + this.arrayTable[Integer.parseInt(newElementVal)]
    );

    return;
  }

  /* Better hash function. Uses modulus index. */
  protected void hashFunctionMod(String newElementVal) {
    int arrayIndex = Integer.parseInt(newElementVal) % this.arrayTable.length;
    System.out.println(
      "Modulus index= " + arrayIndex + " for value " + newElementVal
    );

    /* If theres a collision, search for the next
    available spot using linear probing. */
    while(arrayTable[arrayIndex] != null) {
      ++arrayIndex;
      System.out.println("Collision for " + newElementVal + " try: " + arrayIndex + " instead");
      arrayIndex %= arraySize;
    }

    arrayTable[arrayIndex] = newElementVal;

  }

  protected String findKey(String key) {
    // the hash function
    int arrayIndexHash = Integer.parseInt(key) % this.arrayTable.length;
    while(arrayTable[arrayIndexHash] != null) {
      if(arrayTable[arrayIndexHash] == key) {
        return arrayTable[arrayIndexHash];
      }
      arrayIndexHash++;
      arrayIndexHash %= arraySize; /* Goto the beginning of the table if not found */
    }
    /* They key is not in the table */
    return null;
  }

  public static void main(String[] args) {
    HashTable ht = new HashTable(17);
    ht.hashFunctionMod("35");
    ht.hashFunctionMod("40");
    ht.hashFunctionMod("45");
    ht.hashFunctionMod("50");
    ht.hashFunctionMod("55");

    ht.hashFunctionMod("60");
    ht.hashFunctionMod("65");
    ht.hashFunctionMod("70");
    ht.hashFunctionMod("75");
    ht.hashFunctionMod("80");

    ht.hashFunctionMod("85");
    ht.hashFunctionMod("90");
    ht.hashFunctionMod("95");
    ht.hashFunctionMod("100");
    ht.hashFunctionMod("105");
  }
}

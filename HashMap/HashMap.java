/*
  Implements a HashMap data structure.
*/

public class HashMap {

  private int size;
  private int capacity;
  private HashEntry[] table;

  public HashMap(int capacity) {
    /* Ensure that the Hash Map's size is always prime */
    if (!isPrime(capacity)) { capacity = findNextPrime(capacity); }
    this.size = 0;
    this.capacity = capacity;
    this.table = new HashEntry[capacity];
  }

  /* Return true if number is prime */
  private static boolean isPrime(int number) {
    if (number < 2) {
      return false;
    }

    for (int i = 2; i < number; ++i) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }

  /* Find the first prime greater than n */
  private static int findNextPrime(int n) {

    int nSquared = (int) Math.pow(n, 2);
    for (int i = n; i < nSquared; ++i) {
      if (isPrime(i) && i > n) {
        return i;
      }
    }
    /* Accounts for n = 1 */
    return n + 1;
  }

  /* Return the hash of the given key */
  /* Note: This is a simple (and bad) hash function. */
  private int applyHashFunction(String key) {
    return (
    key.length() *
      (
        (int) (key.charAt(key.length() - 1)) +
        (int) (key.charAt(0))
      ) % this.capacity);
  }

  /* Return the value hashed to by the key k.
     Return null if the key is not found. */
  protected Integer get(String k) {
    int hash = applyHashFunction(k);

    while (table[hash] != null && table[hash].get() != k) {
      hash = (hash + 1) % this.size;
    }

    /* The key is not in the table */
    if (table[hash] == null) {
      return null;
    }

    else {
      return table[hash].getValue();
    }
  }

  /* Insert the entry with key k and value v */
  protected boolean set(String k, Integer v) {
    /* First check if we can insert the item */
    if (this.getSize() == this.getCapacity()) {
      return false;
    }

    int hash = applyHashFunction(k);

    /* Compute the index where the key can be inserted without a collision. */
    while (table[hash] != null && table[hash].get() != k) {
      hash = (hash + 1) % this.size;
    }

    table[hash] = new HashEntry(k, v);
    this.size++;
    return true;
  }

  /* Remove the entry with key k */
  protected boolean delete(String k) {
    int hash = applyHashFunction(k);

    while(table[hash] != null && table[hash].get() != k) {
      hash = (hash + 1) % this.size;
    }

    /* The key is not in the hash map */
    if (table[hash] == null) {
      return false;
    }

    /* The key exists, remove it */
    else {
      table[hash] = null;
      this.size--;
      return true;
    }
  }

  protected float load() {
    if (this.getSize() == 0) {
      return (float) 0;
    }
    return ((float) this.getSize() / this.getCapacity());
  }

  protected HashEntry[] getTable() {
    return this.table;
  }

  protected int getSize() {
    return this.size;
  }

  protected int getCapacity() {
    return this.capacity;
  }

  /*
    Implements a single item in a HashMap.
  */
  class HashEntry {

    private String key;
    private Integer value;

    public HashEntry(String key, Integer value) {
      this.key = key;
      this.value = value;
    }

    public String get() {
      return this.key;
    }

    public Integer getValue() {
      return this.value;
    }
  }
}

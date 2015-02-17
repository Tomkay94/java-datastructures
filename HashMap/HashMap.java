
/* Implements the hash map data structure */

public class HashMap {
  private int size;
  private HashEntry[] table;

  public HashMap(int size) {
    this.size = size;
    this.table = new HashEntry[size];
  }

  private int applyHashFunction(String key) {
    return (
    key.length() *
      (
        (int) (key.charAt(key.length() - 1)) +
        (int) (key.charAt(0) )
      ) % this.size);
  }

  protected int getKey(String k) {
    int hash = applyHashFunction(k);

    while (table[hash] != null && table[hash].getKey() != k) {
      hash = (hash + 1) % this.size;
    }

    /* The key is not in the table */
    if (table[hash] == null) {
      return -1;
    }

    else {
      return table[hash].getValue();
    }
  }

  protected void put(String k, int v) {
    int hash = applyHashFunction(k);

    while (table[hash] != null && table[hash].getKey() != k) {
      hash = (hash + 1) % this.size;
    }

    table[hash] = new HashEntry(k, v);
    System.out.println("Inserted entry: " + table[hash] + "at index: " + hash);
  }

}


/* Implements the HashMap data structure
   using an array of HashEntry objects. */

public class HashMap {

  protected int size;
  private HashEntry[] table;

  public HashMap(int size) {
    /* Ensure that the Hash Map's size is always prime */
    if (!isPrime(size)) { size = findNextPrime(size); }
    this.size = size;
    this.table = new HashEntry[size];
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
  private int applyHashFunction(String key) {
    return (
    key.length() *
      (
        (int) (key.charAt(key.length() - 1)) +
        (int) (key.charAt(0))
      ) % this.size);
  }

  /* Return the value hashed to by the key k */
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

  /* Insert the entry with key k and value v */
  protected void put(String k, int v) {
    int hash = applyHashFunction(k);

    while (table[hash] != null && table[hash].getKey() != k) {
      hash = (hash + 1) % this.size;
    }

    table[hash] = new HashEntry(k, v);
  }

  /* Remove the entry with key k */
  protected boolean delete(String k) {
    int hash = applyHashFunction(k);

    while(table[hash] != null && table[hash].getKey() != k) {
      hash = (hash + 1) % this.size;
    }

    /* The key is not in the hash map */
    if (table[hash] == null) {
      return false;
    }

    /* Remove the key */
    else {
      table[hash] = null;
      return true;
    }
  }

}

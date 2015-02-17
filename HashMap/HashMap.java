
/* Implements the hash map data structure */

public class HashMap {

  protected int size;
  private HashEntry[] table;

  public HashMap(int size) {
    int primeSize = findNextPrime(size);
    this.size = primeSize;
    this.table = new HashEntry[primeSize];
  }

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

  private static int findNextPrime(int n) {

    int nSquared = (int) Math.pow(n, 2);
    for (int i = n; i < nSquared; ++i) {
      if (isPrime(i) && i > n) {
        return i;
      }
    }
    /* Accounts for n = 1 */
    return nSquared + 1;
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
  }
}


/* Acts as a single element in a HashMap */

public class HashEntry {

  private String key;
  private int value;

  public HashEntry(String key, int value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return this.key;
  }

  public int getValue() {
    return this.value;
  }
}

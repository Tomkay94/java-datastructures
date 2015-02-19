
/* Acts as a single element in a HashMap */

public class HashEntry {

  private String key;
  private Integer value;

  public HashEntry(String key, Integer value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return this.key;
  }

  public Integer getValue() {
    return this.value;
  }
}

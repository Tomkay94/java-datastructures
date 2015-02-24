public class DynamicArray {

  protected int size;
  private int[] growingArray;

  public DynamicArray(int size) {
    this.size = 0;
    this.growingArray = new int[size];
  }

}

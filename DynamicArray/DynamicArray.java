public class DynamicArray {

  private int size;
  private int capacity;
  private int resizeFactor;
  private int[] growingArray;

  public DynamicArray(int capacity, int resizeFactor) {
    this.size = 0;
    this.capacity = capacity;
    this.resizeFactor = 0;
    this.growingArray = new int[size];
  }

  /* Copy the elements of the current array into a larger array.
     Return the new larger array. */
  private int[] resizeAndFillArray() {
    int newCapacity = capacity * resizeFactor;
    int[] grownArray = new int[newCapacity];
    for (int i = 0; i < this.size; ++i) {
      grownArray[i] = this.growingArray[i];
    }
    this.capacity = newCapacity;
    return grownArray;
  }

  /* Insert a new item into the array. */
  protected void insert(int item) {
    /* The current array is full, resize it. */
    if (this.size == this.capacity) {
      this.growingArray = resizeAndFillArray();
    }
    this.growingArray[size] = item;
    this.size++;
    return;
  }

  /* Remove the item at index from the array. */
  protected int remove(int index) {
    int removed = this.growingArray[index];
    this.growingArray[index] = -1;
    this.size--;
    return removed;
  }

  /* Return the number of elements in the dynamic array. */
  protected int getSize() {
    return this.size;
  }

  /* Return the capacity for the dynamic array. */
  protected int getCapacity() {
    return this.capacity;
  }

  /* Return the resize factor for the dynamic array. */
  protected int getResizeFactor() {
    return this.resizeFactor;
  }

  /* Update the resize factor for the dynamic array. */
  protected void setResizeFactor(int newFactor) {
    this.resizeFactor = newFactor;
  }

}

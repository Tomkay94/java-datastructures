public class DynamicArray {

  private int size;
  private int capacity;
  private int resizeFactor;
  private Integer[] growingArray;

  public DynamicArray(int capacity, int resizeFactor) {
    this.size = 0;
    this.capacity = capacity;
    this.resizeFactor = resizeFactor;
    this.growingArray = new Integer[capacity];
  }

  /* Copy the elements of the current array into a larger array.
     Return the new larger array. */
  private Integer[] resizeAndPopulateArray() {
    int newCapacity = capacity * resizeFactor;
    Integer[] grownArray = new Integer[newCapacity];

    /* Insert the old array's elements into the new larger array. */
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
      this.growingArray = resizeAndPopulateArray();
    }

    this.growingArray[this.size] = item;
    ++this.size;
    return;
  }

  /* Remove the item at index from the array. */
  protected Integer removeAtIndex(int index) {
    Integer removed = this.growingArray[index];
    this.growingArray[index] = null;
    --this.size;
    return removed;
  }

  /* Return true if the element exists in the array */
  protected boolean hasElement(Integer element) {
    for (int i = 0; i < this.getSize(); ++i) {
      if (this.growingArray[i].equals(element.intValue())) {
        return true;
      }
    }
    return false;
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

  /* Return the element at the index. */
  protected Integer getElementByIndex(int index) {
    return this.growingArray[index];
  }

  /* Update the resize factor for the dynamic array. */
  protected void setResizeFactor(int newFactor) {
    this.resizeFactor = newFactor;
  }

  protected void show() {
    for(int i = 0; i < this.size; ++i) {
      System.out.println("Array at index [" + i + "] is: " + this.growingArray[i]);
    }
  }

}

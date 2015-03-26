public class DynamicArray {

  private int size;
  private int capacity;
  private int resizeFactor;
  private int[] growingArray;

  public DynamicArray(int capacity, int resizeFactor) {
    this.size = 0;
    this.capacity = capacity;
    this.resizeFactor = resizeFactor;
    this.growingArray = new int[capacity];
  }

  /* Copy the elements of the current array into a larger array.
     Return the new larger array. */
  private int[] resizeAndPopulateArray() {
    int newCapacity = capacity * resizeFactor;
    int[] grownArray = new int[newCapacity];

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
  protected int removeAtIndex(int index) {
    /* Copy the array from the remove index to the end. */
    int[] copiedElements = new int[this.getSize() - index - 1];

    for (int i = index + 1, j = 0; i < this.getSize(); ++i, ++j) {
      copiedElements[j] = this.growingArray[i];
    }

    /* Remove the element by copying over it's index. */
    int[] updatedArray = new int[this.getCapacity()];
    --this.size;

    for (int i = 0, j = 0; i < this.getSize(); ++i) {
      if (i < index) {
        updatedArray[i] = this.growingArray[i];
      }
      else {
        updatedArray[i] = copiedElements[j];
        ++j;
      }
    }

    int removedElement = this.growingArray[index];
    this.growingArray = updatedArray;
    return removedElement;
  }

  /* Return true if the element exists in the array */
  protected boolean hasElement(int element) {
    for (int i = 0; i < this.getSize(); ++i) {
      if (this.growingArray[i] == element) {
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
  protected int getElementByIndex(int index) {
    return this.growingArray[index];
  }

  /* Update the resize factor for the dynamic array. */
  protected void setResizeFactor(int newFactor) {
    this.resizeFactor = newFactor;
  }

  protected void show() {
    for(int i = 0; i < this.getSize(); ++i) {
      System.out.println("Array at index [" + i + "] is: " + this.growingArray[i]);
    }
  }
}

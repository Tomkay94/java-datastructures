
/* Implements the Min Heap data structure. */

public class MinHeap {

  private int size;
  private int[] heapArray;

  public MinHeap(int size) {
    this.size = 0;
    this.heapArray = new int[size];
  }

  /* Return the root of the heap without removing it.
     Return -1 if the heap is empty. */
  protected int getMin() {
    return ( !this.isEmpty() ? this.heapArray[0] : -1 );
  }

  /* Return true if the given index is a leaf in the heap. */
  protected boolean isLeaf(int index) {
    return (index > (this.size / 2)) && (index < this.size);
  }

  /* Return true if the heap has no elements. */
  protected boolean isEmpty() {
    return (this.size == 0);
  }

  /* Return the left child index of index. */
  protected int getLeftChildIndex(int index) {
    return (2 * index + 1);
  }

  /* Return the right child index of index. */
  protected int getRightChildIndex(int index) {
    return (2 * index + 2);
  }

  /* Return the parent index of index.
     Return -1 if the index is the root. */
  protected int getParentIndex(int index)  {
    return ( (index > 0) ? ((index - 1) / 2) : -1 );
  }

  /* Insert an element with value into the heap. */
  protected boolean insert(int value) {
    if (this.size < this.heapArray.length) {
      ++this.size;
      this.heapArray[this.size - 1] = value;
      this.siftUp(this.size - 1);
      return true;
    }
    return false;
  }

  /* Traverse up the heap and swap elements which
     do not fulfill the min-heap property. */
  protected void siftUp(int index) {
    int parentIndex;
    int tmp;

    /* Stop when the heap root is reached. */
    if (index != 0) {
      parentIndex = this.getParentIndex(index);

      /* The min-heap property is violated */
      if (this.heapArray[parentIndex] > this.heapArray[index]) {

        /* Swap the elements */
        tmp = this.heapArray[parentIndex];
        this.heapArray[parentIndex] = this.heapArray[index];
        this.heapArray[index] = tmp;

        this.siftUp(parentIndex);
      }
    }
  }

  /* Return the element at index. */
  protected int getElementByIndex(int index) {
    return this.heapArray[index];
  }

  /* Return the array representing the heap. */
  protected int[] getHeapArray() {
    return this.heapArray;
  }

  /* Return the number of elements in the heap. */
  protected int getSize() {
    return this.size;
  }

  /* Display the heap's structure. */
  protected void displayHeap() {

  }
}

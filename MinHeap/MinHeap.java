
/* Implements the Min Heap data structure. */

public class MinHeap {

  private int[] heapArray;
  private int size;

  public MinHeap(int size) {
    this.size = 0;
    this.heapArray = new int[size];
  }

  protected int getMin() {
    if (!this.isEmpty()) {
      return heapArray[0];
    }
    return -1;
  }

  protected boolean isLeaf(int index) {
    return (index > (this.size / 2)) && (index < this.size);
  }

  protected boolean isEmpty() {
    return this.size == 0;
  }

  protected int getLeftChildIndex(int index) {
    return 2 * index + 1;
  }

  protected int getRightChildIndex(int index) {
    return 2 * index + 2;
  }

  protected int getParentIndex(int index)  {
    return (index - 1) / 2;
  }

  protected boolean insert(int value) {
    if (!this.isEmpty()) {
      size++;
      heapArray[size - 1] = value;
      siftUp(size - 1);
      return true;
    }
    return false;
  }

  protected void siftUp(int index) {
    int parentIndex, tmp;
    if (index != 0) {
      parentIndex = getParentIndex(index);
      if (heapArray[parentIndex] > heapArray[index]) {
        tmp = heapArray[parentIndex];
        heapArray[parentIndex] = heapArray[index];
        heapArray[index] = tmp;
        siftUp(parentIndex);
      }
    }
  }

  protected int[] getHeapArray() {
    return this.heapArray;
  }

  protected int getSize() {
    return this.size;
  }

}

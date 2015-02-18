public class MinHeap {

  private int[] heapArray;
  private int heapSize;

  public MinHeap(int heapSize) {
    this.heapSize = 0;
    this.heapArray = new int[heapSize];
  }

  protected int getMin() {
    if (!this.isEmpty()) {
      return heapArray[0];
    }
    return -1;
  }

  protected boolean isEmpty() {
    return this.heapSize == 0;
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

  protected void insert(int value) {
    if (!this.isEmpty()) {
      heapSize++;
      data[heapSize - 1] = value;
      siftUp(heapSize - 1);
    }
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
  
}

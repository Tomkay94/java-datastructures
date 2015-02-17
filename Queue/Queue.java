
/* Implements the Queue data structure
   using a String array. */

public class Queue {

  private int size;
  private int capacity;
  private String[] queueArray;

  public Queue(int capacity) {
    this.capacity = capacity;
    this.queueArray = new String[capacity];
  }

  private void _shiftQueue() {
    for(int i = 1; i < this.queueArray.length; ++i) {
      this.queueArray[i - 1] = this.queueArray[i];
    }
    this.queueArray[queueArray.length - 1] = null;
    return;
  }

  protected void enqueue(String item) {
    if (this.hasCapacity()) {
      this.queueArray[size] = item;
      this.size++;
    }
    return;
  }

  protected String dequeue() {
    if (this.isEmpty()) {
      String dequeuedItem = this.queueArray[0];
      this._shiftQueue();
      this.size--;
      return dequeuedItem;
    }
    return null;
  }

  protected boolean hasCapacity() {
    return this.size < this.capacity;
  }

  protected boolean isEmpty() {
    return this.size == 0;
  }

  protected void displayQueue() {
    for (String item : this.queueArray) {
      if (item != null) {
        System.out.println(item);
      }
    }
    return;
  }
}

import java.util.List;
import java.util.ArrayList;

/* Implements the Queue data structure
   using a String array. */

public class Queue<T> {

  private int size;
  private int capacity;
  private List<T> queueArray;

  public Queue(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    this.queueArray = new ArrayList<T>(capacity);
  }

  /* Add the item to the top of the queue.
  Return true if the item was successfully added.*/
  protected boolean enqueue(T item) {
    if (this.size < this.capacity) {
      this.queueArray.add(item);
      this.size++;
      return true;
    }
    return false;
  }

  /* Remove the item from the bottom of the queue.
  Return the node that was removed.*/
  protected T dequeue() {
    if (!this.isEmpty()) {
      T dequeuedItem = this.queueArray.remove(0);
      this.size--;
      return dequeuedItem;
    }
    return null;
  }

  protected boolean isEmpty() {
    return this.size == 0;
  }

  protected void displayQueue() {
    for (T item : this.queueArray) {
      if (item != null) {
        System.out.println(item);
      }
    }
    return;
  }

  protected int getSize() {
    return this.size;
  }
}

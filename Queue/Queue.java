import java.util.List;
import java.util.ArrayList;

/* Implements the Queue data structure
   using a String array. */

public class Queue<T> {

  protected int size;
  private List<T> queueArray;

  public Queue() {
    this.size = 0;
    this.queueArray = new ArrayList<T>();
  }

  protected void enqueue(T item) {
    this.queueArray.add(item);
    this.size++;
    return;
  }

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
}
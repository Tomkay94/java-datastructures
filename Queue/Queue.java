
/* Implements the Queue data structure. */

public class Queue<T> {

  private int size;
  private Node<T> head;
  private Node<T> tail;

  private List<T> queueArray;

  public Queue() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  /* Add the item to the top of the queue.
  Return true if the item was successfully added.*/
  protected void enqueue(T data) {
    return;
  }

  /* Remove the item from the bottom of the queue.
  Return the node that was removed.*/
  protected Node<T> dequeue() {
    return;
  }

  protected boolean isEmpty() {
    return this.getSize == 0;
  }

  protected void show() {
    return;
  }

  protected int getSize() {
    return this.size;
  }

  protected void setHead(Node<T> newHead) {
    return;
  }

  protected void setTail(Node<T> newTail) {
    return;
  }

  protected boolean hasItem(Node<T> item) {
    return false;
  }
}

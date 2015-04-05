
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

    /* Empty enqueue */
    if (this.head == null) {
      this.head = new Node<T>(data);
      this.tail = this.head;
      ++this.size;
      return;
    }

    Node<T> newTail = new Node<T>(data);
    this.tail.next = newTail;
    this.tail = newTail;
    return;
  }

  /* Remove the item from the bottom of the queue.
  Return the node that was removed.*/
  protected Node<T> dequeue() {
    if (this.head == null) {
      return null;
    }

    this.head = this.head.remove(this.head);
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

  protected Node<T> hasItem(T item) {
    Node<T> curr = this.head;
    while (curr != null) {
      if (curr.data.equals(item)) {
        return curr;
      }
      curr = curr.next;
    }
    return null;
  }
}

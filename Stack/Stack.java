/*
  Implements a Stack data structure.
*/

public class Stack<T> {

  private int size;
  private Node<T> top;
  private Node<T> stack;

  public Stack() {
    this.size = 0;
    this.top = null;
    this.stack = null;
  }

  /* Push the new item to the top of the stack.
  Return true if the item was successfully added. */
  /* Time Complexity: O(1) */
  protected void push(T item) {

    Node<T> newTail = new Node<T>(item);

    /* First push */
    if (this.top == null) {
      this.top = newTail;
      ++this.size;
      return;
    }

    this.top.appendToTail(newTail);
    this.top = newTail;
    ++this.size;
    return;
  }

  /* Remove the item off the top of the stack and return it. */
  /* Time Complexity: O(1) */
  protected Node<T> pop() {
    if (!this.isEmpty()) {
      Node<T> poppedItem = this.top;
      this.top = this.top.resetTail();
      --this.size;
      return poppedItem;
    }
    return null;
  }

  /* Return true if the stack is empty. */
  /* Time Complexity: O(1) */
  protected boolean isEmpty() {
    return this.size == 0;
  }

  /* Return the item on the top of the stack without removing it.*/
  /* Time Complexity: O(1) */
  protected T peek() {
    return this.top.data;
  }

  /* Show the elements in the stack */
  /* Time Complexity: O(n), n is the # of items in the stack. */
  protected void show() {
    Node<T> top = this.top;
    while (top != null) {
      System.out.print(top.data + " ");
      top = top.next;
    }
    return;
  }

  /* Return the number of items in the stack. */
  protected int getSize() {
    return this.size;
  }
}

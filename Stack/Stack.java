/*
  Implements the Stack data structure.
*/
public class Stack<T> {

  private Node<T> top;
  private Node<T> stack;
  private int size;

  public Stack() {
    this.size = 0;
    this.stack = null;
  }

  /* Push the new item to the top of the stack.
  Return true if the item was successfully added. */
  /* Time Complexity: O(1) */
  protected void push(T item) {
    this.top.appendToTail(new Node<T> item);
    ++this.size;
    return;
  }

  /* Remove the item off the top of the stack and return it. */
  /* Time Complexity: O(1) */
  protected T pop() {
    this.top = this.top.resetTail;
    --this.size;
    return;
  }

  /* Return true if the stack is empty. */
  /* Time Complexity: O(1) */
  protected boolean isEmpty() {
    return this.size == 0;
  }

  /* Return the item on the top of the stack without removing it.*/
  /* Time Complexity: O(n) */
  protected T peek() {
    return this.top;
  }

  /* Show the elements in the stack */
  /* Time Complexity: O(n), n is the # of items in the stack. */
  protected void displayStack() {
    return;
  }

  protected int getSize() {
    return this.size;
  }
}

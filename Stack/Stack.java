import java.util.List;
import java.util.ArrayList;

/* Implements the Stack data structure
   using a String array. */

public class Stack<T> {

  protected int size;
  private int capacity;
  private List<T> stackArray;

  public Stack(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    this.stackArray = new ArrayList<T>();
  }

  /* Push the new item to the top of the stack. */
  /* Time Complexity: O(1) */
  protected void push(T item) {
    if (this.size < this.capacity) {
      this.stackArray.add(item);
      this.size++;
    }
    return;
  }

  /* Pop the item off the top of the stack and return it. */
  /* Time Complexity: O(1) */
  protected T pop() {
    if (this.size > 0) {
      T poppedItem = this.stackArray.remove(size - 1);
      this.size--;
      return poppedItem;
    }
    return null;
  }

  /* Determine if the stack is empty. */
  /* Time Complexity: O(1) */
  protected boolean isEmpty() {
    return this.size == 0;
  }

  /* Determine if the stack still has space for more elements. */
  /* Time Complexity: O(1) */
  protected boolean hasSpace() {
    return this.size < this.capacity;
  }

  /* Return the item on the top of the stack without removing it.*/
  /* Time Complexity: O(n) */
  protected T peek() {
    if (!this.isEmpty()) {
      return this.stackArray.get(size - 1);
    }
    return null;
  }

  /* Show the elements in the stack */
  /* Time Complexity: O(n), n is the # of items in the stack. */
  protected void displayStack() {
    for (T item : this.stackArray) {
      if (item != null) {
      System.out.println(item);
      }
    }
  }

}

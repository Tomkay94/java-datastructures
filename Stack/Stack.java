
/* Implements the Stack data structure. */

public class Stack {

  protected int size;
  private int capacity;
  private String[] stackArray;

  public Stack(int capacity) {
    this.capacity = capacity;
    this.stackArray = new String[capacity];
  }

  /* Push the new item to the top of the stack. */
  protected void push(String item) {
    if (this.size < this.capacity) {
      this.stackArray[size] = item;
      this.size++;
    }
    return;
  }

  /* Pop the item off the top of the stack and return it. */
  protected String pop() {
    if (this.size > 0) {
      String poppedItem = this.stackArray[size - 1];
      this.stackArray[size - 1] = null;
      this.size--;
      return poppedItem;
    }
    return null;
  }

  /* Determine if the stack is empty. */
  protected boolean isEmpty() {
    return this.size == 0;
  }

  /* Determine if the stack still has space for more elements. */
  protected boolean hasSpace() {
    return this.size < this.capacity;
  }

  /* Show the elements in the stack */
  protected void displayStack() {
    for (String item : this.stackArray) {
      if (item != null) {
      System.out.println(item);
      }
    }
  }

}

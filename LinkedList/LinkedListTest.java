import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTest {

  @Test
  public void testNodeConstructor() {
    Node<Integer> head = new Node<Integer>(10);

    assertEquals(head.data, Integer.valueOf(10));
    assertEquals(head.next, null);
  }

  @Test
  public void testAppendToTailToOneNode() {
    Node<Integer> head      = new Node<Integer>(10);
    Node<Integer> afterHead = new Node<Integer>(15);
    head.appendToTail(afterHead);

    assertEquals(head.next, afterHead);
  }

  @Test
  public void testChainOfNodes() {
    Node<Integer> head  = new Node<Integer>(5);
    Node<Integer> node1 = new Node<Integer>(10);
    Node<Integer> node2 = new Node<Integer>(15);
    Node<Integer> tail  = new Node<Integer>(20);

    /* Assert all references are independent. */
    assertNull(head.next);
    assertNull(node1.next);
    assertNull(node2.next);
    assertNull(tail.next);

    head.appendToTail(node1);
    head.appendToTail(node2);
    head.appendToTail(tail);

    /* Assert references are correct. */
    assertNotNull(head.next);
    assertNotNull(node1.next);
    assertNotNull(node2.next);
    assertNull(tail.next);

    /* Assert their contents are correct. */
    assertEquals(head.data, Integer.valueOf(5));
    assertEquals(head.next.data, Integer.valueOf(10));
    assertEquals(node1.next.data, Integer.valueOf(15));
    assertEquals(node2.next.data, Integer.valueOf(20));
    assertEquals(tail.data, Integer.valueOf(20));
  }

  @Test
  public void testOddNodePalindrome() {
    Node<Integer> head = new Node<Integer>(10);
    head.appendToTail(new Node<Integer>(15));
    head.appendToTail(new Node<Integer>(20));
    head.appendToTail(new Node<Integer>(15));
    head.appendToTail(new Node<Integer>(10));

    assertTrue(head.isPalindrome());
  }

  @Test
  public void testEvenNodePalindrome() {
    Node<Integer> head = new Node<Integer>(10);
    head.appendToTail(new Node<Integer>(15));
    head.appendToTail(new Node<Integer>(15));
    head.appendToTail(new Node<Integer>(10));

    assertTrue(head.isPalindrome());
  }

  @Test
  public void testInvalidPalindrome() {
    Node<Integer> head = new Node<Integer>(10);
    head.appendToTail(new Node<Integer>(15));
    head.appendToTail(new Node<Integer>(20));
    head.appendToTail(new Node<Integer>(15));

    assertFalse(head.isPalindrome());
  }

  @Test
  public void testOneNodePalindrome() {
    Node<Integer> head = new Node<Integer>(10);

    assertTrue(head.isPalindrome());
  }

  @Test
  public void testOneNodeFindMedian() {
    Node<Integer> head = new Node<Integer>(10);

    assertEquals(head.findMedianElement(), head);
  }

  @Test
  public void testOddNodeFindMedian() {
    Node<Integer> medianNode = new Node<Integer>(10);

    Node<Integer> head = new Node<Integer>(5);
    head.appendToTail(medianNode);
    head.appendToTail(new Node<Integer>(15));

    assertEquals(head.findMedianElement(), medianNode);
  }

  @Test
  public void testEvenNodeFindMedian() {
    Node<Integer> medianNode = new Node<Integer>(10);

    Node<Integer> head = new Node<Integer>(5);
    head.appendToTail(medianNode);
    head.appendToTail(new Node<Integer>(15));
    head.appendToTail(new Node<Integer>(20));

    assertEquals(head.findMedianElement(), medianNode);
  }

  @Test
  public void testFindListLengthForOneNode() {
    Node<Integer> head = new Node<Integer>(10);

    assertEquals(head.getLength(), 1);
  }

  @Test
  public void testFindListLengthForManyNodes() {
    Node<Integer> head = new Node<Integer>(10);
    head.appendToTail(new Node<Integer>(15));
    head.appendToTail(new Node<Integer>(20));
    head.appendToTail(new Node<Integer>(25));
    head.appendToTail(new Node<Integer>(30));
    head.appendToTail(new Node<Integer>(35));
    head.appendToTail(new Node<Integer>(40));

    assertEquals(head.getLength(), 7);
  }

  @Test
  public void testCircularListOneNode() {
    Node<Integer> head = new Node<Integer>(10);
    head.appendToTail(head);

    assertTrue(head.isCircular());
  }

  @Test
  public void testCircularListManyNodes() {
    Node<Integer> head = new Node<Integer>(10);
    head.appendToTail(new Node<Integer>(15));
    head.appendToTail(new Node<Integer>(20));
    head.appendToTail(new Node<Integer>(25));
    head.appendToTail(new Node<Integer>(30));
    head.appendToTail(new Node<Integer>(35));
    head.appendToTail(head);

    assertTrue(head.isCircular());
  }

  @Test
  public void testNonCircularOneNode() {
    Node<Integer> head = new Node<Integer>(10);

    assertFalse(head.isCircular());
  }

  @Test
  public void testDeleteFirstNode() {
    Node<Integer> head   = new Node<Integer>(10);
    Node<Integer> second = new Node<Integer>(15);

    head.appendToTail(second);
    head.appendToTail(new Node<Integer>(20));

    head = head.delete(head, head.data);

    assertEquals(head, second);
  }

  @Test
  public void testDeleteLastNode() {
    Node<Integer> head       = new Node<Integer>(10);
    Node<Integer> secondLast = new Node<Integer>(25);
    Node<Integer> last       = new Node<Integer>(30);

    head.appendToTail(new Node<Integer>(15));
    head.appendToTail(new Node<Integer>(20));
    head.appendToTail(secondLast);
    head.appendToTail(last);

    head = head.delete(head, last.data);

    assertEquals(secondLast.next, null);
  }

  @Test
  public void testDeleteNodeAffectsLength() {
    Node<Integer> head = new Node<Integer>(10);
    head.appendToTail(new Node<Integer>(15));
    head.appendToTail(new Node<Integer>(20));
    head.appendToTail(new Node<Integer>(25));
    head.appendToTail(new Node<Integer>(30));

    head = head.delete(head, 25);

    assertEquals(head.getLength(), 4);
  }
}

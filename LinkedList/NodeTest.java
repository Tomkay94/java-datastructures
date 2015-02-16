import org.junit.*;

public class NodeTest {

  @Test
  public void testAppendToTailToOneNode() {
    Node head      = new Node(10);
    Node afterHead = new Node(15);
    head.appendToTail(afterHead);

    Assert.assertEquals(head.next, afterHead);
  }

  @Test
  public void testAppendToTailToManyNodes() {
    Node head       = new Node(10);
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(20));
    head.appendToTail(new Node(25));
    Node end        = new Node(30);
    head.appendToTail(end);

    Assert.assertEquals(head.next.next.next.next, end);
  }

  @Test
  public void testOddNodePalindrome() {
    Node head       = new Node(10);
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(20));
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(10));

    Assert.assertTrue(head.isPalindrome());
  }

  @Test
  public void testEvenNodePalindrome() {
    Node head       = new Node(10);
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(10));

    Assert.assertTrue(head.isPalindrome());
  }

  @Test
  public void testInvalidPalindrome() {
    Node head       = new Node(10);
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(20));
    head.appendToTail(new Node(15));

    Assert.assertFalse(head.isPalindrome());
  }

  @Test
  public void testOneNodePalindrome() {
    Node head      = new Node(10);

    Assert.assertTrue(head.isPalindrome());
  }

  @Test
  public void testOneNodeFindMedian() {
    Node head       = new Node(10);

    Assert.assertEquals(head.findMedianElement(), head);
  }

  @Test
  public void testOddNodeFindMedian() {
    Node medianNode = new Node(10);

    Node head       = new Node(5);
    head.appendToTail(medianNode);
    head.appendToTail(new Node(15));

    Assert.assertEquals(head.findMedianElement(), medianNode);
  }

  @Test
  public void testEvenNodeFindMedian() {
    Node medianNode = new Node(10);

    Node head       = new Node(5);
    head.appendToTail(medianNode);
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(20));

    Assert.assertEquals(head.findMedianElement(), medianNode);
  }

  @Test
  public void testFindListLengthForOneNode() {
    Node head       = new Node(10);

    Assert.assertEquals(head.getLength(), 1);
  }

  @Test
  public void testFindListLengthForManyNodes() {
    Node head       = new Node(10);
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(20));
    head.appendToTail(new Node(25));
    head.appendToTail(new Node(30));
    head.appendToTail(new Node(35));
    head.appendToTail(new Node(40));

    Assert.assertEquals(head.getLength(), 7);
  }

  @Test
  public void testCircularListOneNode() {
    Node head = new Node(10);
    head.appendToTail(head);

    Assert.assertTrue(head.isCircular());
  }

  @Test
  public void testCircularListManyNodes() {
    Node head       = new Node(10);
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(20));
    head.appendToTail(new Node(25));
    head.appendToTail(new Node(30));
    head.appendToTail(new Node(35));
    head.appendToTail(head);

    Assert.assertTrue(head.isCircular());
  }

  @Test
  public void testNonCircularOneNode() {
    Node head = new Node(10);

    Assert.assertFalse(head.isCircular());
  }

  @Test
  public void testDeleteFirstNode() {
    Node head   = new Node(10);
    Node second = new Node(15);

    head.appendToTail(second);
    head.appendToTail(new Node(20));

    head = head.delete(head, head.data);

    Assert.assertEquals(head, second);
  }

  @Test
  public void testDeleteLastNode() {
    Node head       = new Node(10);
    Node secondLast = new Node(25);
    Node last       = new Node(30);

    head.appendToTail(new Node(15));
    head.appendToTail(new Node(20));
    head.appendToTail(secondLast);
    head.appendToTail(last);

    head = head.delete(head, last.data);

    Assert.assertEquals(secondLast.next, null);
  }

  @Test
  public void testDeleteNodeAffectsLength() {
    Node head       = new Node(10);
    head.appendToTail(new Node(15));
    head.appendToTail(new Node(20));
    head.appendToTail(new Node(25));
    head.appendToTail(new Node(30));

    head = head.delete(head, 25);

    Assert.assertEquals(head.getLength(), 4);
  }
}

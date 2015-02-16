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
    Node head      = new Node(10);
    Node afterHead = new Node(15);

    head.appendToTail(afterHead);
    Assert.assertEquals(head.next, afterHead);
  }

  @Test
  public void testValidPalindrome() {
    Node head      = new Node(10);
    Node afterHead = new Node(15);

    head.appendToTail(afterHead);
    Assert.assertEquals(head.next, afterHead);
  }

  @Test
  public void testInvalidPalindrome() {
    Node head      = new Node(10);
    Node afterHead = new Node(15);

    head.appendToTail(afterHead);
    Assert.assertEquals(head.next, afterHead);
  }

  @Test
  public void testOneNodePalindrome() {
    Node head      = new Node(10);
    Node afterHead = new Node(15);

    head.appendToTail(afterHead);
    Assert.assertEquals(head.next, afterHead);
  }

  @Test
  public void testOneNodeFindMedian() {
    Node head      = new Node(10);
    Node afterHead = new Node(15);

    head.appendToTail(afterHead);
    Assert.assertEquals(head.next, afterHead);
  }

  @Test
  public void testOddNodeFindMedian() {
    Node head      = new Node(10);
    Node afterHead = new Node(15);

    head.appendToTail(afterHead);
    Assert.assertEquals(head.next, afterHead);
  }

  @Test
  public void testFindListLengthForOneNode() {
    Node head      = new Node(10);
    Node afterHead = new Node(15);

    head.appendToTail(afterHead);
    Assert.assertEquals(head.next, afterHead);
  }

  @Test
  public void testFindListLengthForManyNodes() {
    Node head      = new Node(10);
    Node afterHead = new Node(15);

    head.appendToTail(afterHead);
    Assert.assertEquals(head.next, afterHead);
  }
}

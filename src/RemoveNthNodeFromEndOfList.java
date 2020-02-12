public class RemoveNthNodeFromEndOfList {

  static class ListNode {
    int val;
    ListNode next;
    ListNode (int val) {
      this.val = val;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null) return null;
    if(n == 0) return head;

    ListNode first = head;
    ListNode second = head;
    int count = 0;
    //progress second upto n places
    while(count < n) {
      //if nth node from end is head or n > N
      if(second.next == null) {
        return head.next;
      }
      ++count;
      second = second.next;
    }
    //when second reaches end, first would reach nth node from end
    while(second.next != null) {
      first = first.next;
      second = second.next;
    }
    //delete nth node which is first.next
    first.next = first.next.next;
    return head;
  }
}

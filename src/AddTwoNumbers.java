public class AddTwoNumbers {

  public static void main (String...strings) {
    AddTwoNumbers sol = new AddTwoNumbers();
    ListNode l1 = new ListNode(9);
    l1.next = new ListNode(8);
    /*l1.next.next = new ListNode(3);*/
    ListNode l2 = new ListNode(1);
    //l2.next = new ListNode(3);
    //l2.next.next = new ListNode(4);
    ListNode result = sol.addTwoNumbers(l1,l2);
    System.out.println(result);
  }

  static class ListNode {
    int val;
    ListNode next;
    ListNode (int val) {
      this.val = val;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    int carry = 0;
    ListNode result = null;
    ListNode retVal = null;
    while(l1 != null & l2 != null) {
      int sum = l1.val + l2.val + carry;
      int resultVal = sum%10;
      if(result == null) {
        result = new ListNode(resultVal);
        retVal = result;
      }else {
        result.next = new ListNode(resultVal);
        result = result.next;
      }
      carry = sum/10;
      l1 = l1.next;
      l2 = l2.next;
    }
    while(l1 != null) {
      int sum = l1.val + carry;
      int resultVal = sum%10;
      result.next = new ListNode(resultVal);
      result = result.next;
      carry = sum/10;
      l1 = l1.next;
    }
    while(l2 != null) {
      int sum = l2.val + carry;
      int resultVal = sum%10;
      result.next = new ListNode(resultVal);
      result = result.next;
      carry = sum/10;
      l2 = l2.next;
    }
    if(carry > 0) {
      result.next = new ListNode(carry);
    }
    return retVal;
  }
}

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersII {
  public static void main(String...strings) {
    AddTwoNumbersII sol = new AddTwoNumbersII();
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
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
    List<Integer> l1List = new ArrayList<>();
    List<Integer> l2List = new ArrayList<>();
    ListNode copyL1 = l1;
    ListNode copyL2 = l2;
    while (copyL1 != null) {
      l1List.add(copyL1.val);
      copyL1 = copyL1.next;
    }
    while (copyL2 != null) {
      l2List.add(copyL2.val);
      copyL2 = copyL2.next;
    }
    int l1Len = l1List.size(), l2Len = l2List.size();
    List<Integer> longer = null, shorter = null;
    if(l1Len > l2Len) {
      longer = l1List;
      shorter = l2List;
    }else if(l2Len > l1Len) {
      longer = l2List;
      shorter = l1List;
    } else {
      longer = l1List;
      shorter = l2List;
    }
    List<Integer> zeroList = new ArrayList<>();
    for(int i=0; i<Math.abs(l1Len-l2Len); i++) {
      zeroList.add(0);
    }
    int[] result = new int[longer.size()];
    if(shorter != null) {
      zeroList.addAll(shorter);
      shorter = zeroList;
      for(int i=longer.size()-1; i>=0; i--) {
        int sum = carry + longer.get(i) + shorter.get(i);
        int remainder = sum%10;
        result[i] = remainder;
        carry = sum/10;
      }
    }
    ListNode node = null, retVal = null;
    if(carry > 0) {
      node = new ListNode(carry);
      retVal = node;
    }
    for(int i=0; i<result.length; i++) {
      if(node == null) {
        node = new ListNode(result[i]);
        retVal = node;
      }else {
        node.next = new ListNode(result[i]);
        node = node.next;
      }
    }
    return retVal;
  }
}

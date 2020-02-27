import java.util.*;

public class ZigZagTraversal {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if(root == null) return Collections.emptyList();
    List<List<Integer>> retVal = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<Integer> list = new ArrayList<>();
    queue.offer(null);
    while(!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if(node == null) {
        if(list.size() > 0) {
          if(retVal.size()%2 == 1) {
            Collections.reverse(list);
          }
          retVal.add(list);
          queue.offer(null);
          list = new ArrayList<>();
        }
      } else  {
        list.add(node.val);
        if(node.left != null) {
          queue.offer(node.left);
        }
        if(node.right != null) {
          queue.offer(node.right);
        }
      }
    }
    return retVal;
  }
}

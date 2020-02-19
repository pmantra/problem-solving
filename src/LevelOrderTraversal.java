import java.util.*;

public class LevelOrderTraversal {

  /**
   * Definition for a binary tree node.
   */
   public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
   }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return Collections.emptyList();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    List<List<Integer>> retVal = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    while(!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if(node == null) {
        if(list.size() > 0) {
          retVal.add(list);
          list = new ArrayList<>();
          queue.add(null);
        }
      }else {
        list.add(node.val);
        if(node.left != null) {
          queue.add(node.left);
        }
        if(node.right != null) {
          queue.add(node.right);
        }
      }
    }
    return retVal;
  }
}

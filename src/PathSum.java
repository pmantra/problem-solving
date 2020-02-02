public class PathSum {

  public static void main(String...strings) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.right = new TreeNode(1);
    int sum = 22;
    PathSum sol = new PathSum();
    System.out.println(sol.hasPathSum(root, sum));
  }

  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public boolean hasPathSum(TreeNode root, int sum) {
    return recursiveHelper(root, sum, 0);
  }

  private boolean recursiveHelper (TreeNode node, int sum, int treeSum) {
    if(node == null) {
      return sum == treeSum;
    }
    treeSum = treeSum + node.val;
    return recursiveHelper(node.left, sum, treeSum) || recursiveHelper(node.right, sum, treeSum);
  }
}

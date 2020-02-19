import java.util.*;

public class VerticalOrderTraversal {

  /**
   * Definition for a binary tree node.
   */
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  static class Coordinate implements Comparable<Coordinate> {
    int x;
    int y;
    int val;
    Coordinate(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }

    @Override
    public boolean equals(Object object) {
      Coordinate coordinate = (Coordinate)object;
      return this.x == coordinate.x && this.y == coordinate.y && this.val == coordinate.val;
    }

    @Override
    public int compareTo(Coordinate that) {
      if (this.x != that.x)
        return Integer.compare(this.x, that.x);
      else if (this.y != that.y)
        return Integer.compare(this.y, that.y);
      else
        return Integer.compare(this.val, that.val);
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<Coordinate> list = new ArrayList<>();
    dfs(root, 0, 0, list);
    Collections.sort(list);
    Map<Integer, List<Integer>> map = new HashMap<>();

    List<List<Integer>> retVal = new ArrayList();
    retVal.add(new ArrayList<Integer>());
    int prev = list.get(0).x;
    for (Coordinate c: list) {
      if (c.x != prev) {
        prev = c.x;
        retVal.add(new ArrayList<Integer>());
      }
      retVal.get(retVal.size() - 1).add(c.val);
    }

    return retVal;

  }

  private void dfs(TreeNode node, int x, int y, List<Coordinate> list) {
    if(node == null) return;
    Coordinate c = new Coordinate(x, y, node.val);
    list.add(c);
    dfs(node.left, x-1, y+1, list);
    dfs(node.right, x+1, y+1, list);
  }
}

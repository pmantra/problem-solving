import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {

  static class Point {
    int row;
    int col;
    char val;

    Point (int row, int col, char val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }

  public int numIslandsBFS(char[][] grid) {
    if(grid == null || grid.length == 0) return 0;
    Queue<Point> queue = new LinkedList<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int count = 0;
    for(int i=0; i<grid.length; i++) {
      for(int j=0; j<grid[i].length; j++) {
        if(grid[i][j] == '1' && !visited[i][j]) {
          Point point = new Point(i, j, grid[i][j]);
          queue.offer(point);
          ++count;
        }
        while (!queue.isEmpty()) {
          Point point = queue.poll();
          int row = point.row;
          int col = point.col;
          if(!visited[row][col]) {
            visited[row][col] = true;
            queue.addAll(getNeighbors(grid, row, col, visited));
          }
        }
      }
    }
    return count;
  }

  private List<Point> getNeighbors (char[][] grid, int row, int col, boolean[][] visited) {
    List<Point> neighbors = new ArrayList<>();
    if(row-1 >= 0 && grid[row-1][col] == '1') {
      neighbors.add(new Point(row-1, col, grid[row-1][col]));
    }
    if(row+1 < grid.length && grid[row+1][col] == '1') {
      neighbors.add(new Point(row+1, col, grid[row+1][col]));
    }
    if(col-1 >= 0 && grid[row][col-1] == '1') {
      neighbors.add(new Point(row, col-1, grid[row][col-1]));
    }
    if(col+1 < grid[0].length && grid[row][col+1] == '1') {
      neighbors.add(new Point(row, col+1, grid[row][col+1]));
    }
    return neighbors;
  }

  public int numIslandsDFS(char[][] grid) {
    if(grid == null || grid.length == 0) return 0;
    int count = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for(int i=0; i<grid.length; i++) {
      for(int j=0; j<grid[0].length; j++) {
        if(grid[i][j] == '1' && !visited[i][j]) {
          dfsHelper(grid, i, j, visited);
          ++count;
        }
      }
    }
    return count;
  }

  private void dfsHelper (char[][] grid, int row, int col, boolean[][] visited) {
    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0' || visited[row][col]) {
      return;
    }

    visited[row][col] = true;
    dfsHelper(grid, row-1, col, visited);
    dfsHelper(grid, row+1, col, visited);
    dfsHelper(grid, row, col-1, visited);
    dfsHelper(grid, row, col+1, visited);
    return;
  }

  public static void main(String...strings) {
    NumberOfIslands sol = new NumberOfIslands();
    char[][] grid = {
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'}
    };
    System.out.println(sol.numIslandsBFS(grid));
    System.out.println(sol.numIslandsDFS(grid));
  }
}

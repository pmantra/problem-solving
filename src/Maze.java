import java.util.ArrayList;
import java.util.List;

public class Maze {

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    return helper(maze, start, destination, visited);
  }

  private boolean helper (int[][] maze, int[] start, int[] destination, boolean[][] visited) {
    int row = start[0];
    int col = start[1];

    if(visited[row][col]) {
      return false;
    }

    if(row == destination[0] && col == destination[1]) {
      return true;
    }

    visited[row][col] = true;

    int up = row-1, down = row+1, left = col-1, right = col+1;
    while(right < maze[0].length && maze[row][right] == 0) {
      right++;
    }
    if(helper(maze, new int[] {row,right-1}, destination, visited)) {
      return true;
    }

    while(left >= 0 && maze[row][left] == 0) {
      left--;
    }
    if(helper(maze, new int[] {row,left+1}, destination, visited)) {
      return true;
    }

    while(up >= 0 && maze[up][col] == 0) {
      up--;
    }
    if(helper(maze, new int[] {up+1,col}, destination, visited)) {
      return true;
    }

    while(down < maze.length && maze[down][col] == 0) {
      down++;
    }
    if(helper(maze, new int[] {down-1,col}, destination, visited)) {
      return true;
    }

    return false;
  }
}

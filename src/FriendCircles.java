import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {
  public int findCircleNumUsingBFS(int[][] matrix) {
    if(matrix.length == 0) return 0;
    boolean[] visited = new boolean[matrix.length];
    int count = 0;
    Queue<Integer> queue = new LinkedList<>();
    for(int i=0; i<matrix.length; i++) {
      if(!visited[i]) {
        visited[i] = true;
        queue.offer(i);
        while (!queue.isEmpty()) {
          Integer startIndex = queue.poll();
          visited[startIndex] = true;
          for(int j=0; j<matrix.length; j++) {
            if(matrix[startIndex][j] == 1 && !visited[j]) {
              queue.offer(j);
            }
          }
        }
        ++count;
      }
    }
    return count;
  }

  public int findCircleNumUsingDFS(int[][] matrix) {
    if(matrix.length == 0) return 0;
    boolean[] visited = new boolean[matrix.length];
    //for each node if not visited mark it as visited and perform dfs from that node
    //increment once if dfs performed from a different start index
    int count = 0;
    for(int i=0; i<matrix.length; i++) {
      if(!visited[i]) {
        visited[i] = true;
        dfs(matrix, visited, i);
        ++count;
      }
    }
    return count;
  }

  private void dfs (int[][] matrix, boolean[] visited, int startIndex) {
    //get neighbors at given startIndex
    for(int i=0; i<matrix.length; i++) {
      //if a cell is 1 and not visited - mark it as visited and recursively call dfs
      if(matrix[startIndex][i] == 1 && !visited[i]) {
        visited[i] = true;
        dfs(matrix, visited, i);
      }
    }
  }
}

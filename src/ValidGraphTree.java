import java.util.ArrayList;
import java.util.List;

public class ValidGraphTree {

  public boolean validTree(int n, int[][] edges) {
    if(n < 2) return true;
    List<List<Integer>> graph = buildGraph(n, edges);
    boolean[] visited = new boolean[n];

    if (dfs(graph, 0, visited, -1))
      return false;

    for (int i = 0; i < n; i++) {
      if (!visited[i])
        return false;
    }

    return true;
  }


  private boolean dfs (List<List<Integer>> graph, int u, boolean[] visited, int parent) {
    visited[u] = true;
    for(int v : graph.get(u)) {
      if(
        (visited[v] && v != parent) ||
          (!visited[v] && dfs(graph, v, visited, u))
      ) {
        return true;
      }
    }
    return false;
  }

  private List<List<Integer>> buildGraph (int n, int[][] edges) {
    List<List<Integer>> graph = new ArrayList<>();
    for(int i=0; i<n; i++) {
      graph.add(new ArrayList<>());
    }

    for(int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    return graph;
  }
}

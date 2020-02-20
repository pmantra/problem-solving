import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponents {
  public int countComponents(int n, int[][] edges) {
    if(n < 2) return n;
    List<List<Integer>> graph = buildGraph(n, edges);
    boolean[] visited = new boolean[n];
    int count = 0;
    for(int i=0; i<graph.size(); i++) {
      if(!visited[i]) {
        visited[i] = true;
        dfs(graph, visited, graph.get(i));
        ++count;
      }
    }
    return count;
  }

  private void dfs (List<List<Integer>>graph, boolean[] visited, List<Integer> list) {
    for(int i : list) {
      if(!visited[i]) {
        visited[i] = true;
        dfs(graph, visited, graph.get(i));
      }
    }
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

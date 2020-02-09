import java.util.*;

public class CourseSchedule {

  public static void main(String...strings) {
    CourseSchedule sol = new CourseSchedule();
    int[][] prerequisites = {{1,0}, {0,1}};
    int numCourses = 2;
    System.out.println(sol.canFinish(numCourses, prerequisites));
    System.out.println(Arrays.toString(sol.findOrder(numCourses, prerequisites)));
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if(prerequisites.length == 0) return true;
    //can finish if graph has no cycle -> if graph has no cycle -> topological order length matches numCourses
    return findOrder(numCourses, prerequisites).length == numCourses;
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if(prerequisites.length == 0) return new int[0];
    //buid adjacency list
    List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
    int[] indegrees = new int[numCourses];
    //calc indegree of each node
    for(List<Integer> list : graph) {
      for(int node : list) {
        indegrees[node]++;
      }
    }
    //find nodes with 0 indegree and use them as starting point for BFS
    Queue<Integer> nodesWithZeroIndegrees = new LinkedList<>();
    for(int i=0; i<indegrees.length; i++) {
      if(indegrees[i] == 0) {
        nodesWithZeroIndegrees.offer(i);
      }
    }
    int[] toplogicalOrder = new int[numCourses];
    int count = 0;
    //traverse all nodes
    while(!nodesWithZeroIndegrees.isEmpty()) {
      int node = nodesWithZeroIndegrees.poll();
      toplogicalOrder[count++] = node;
      //update indegree after traversal
      for(int neighbor : graph.get(node)) {
        --indegrees[neighbor];
        if(indegrees[neighbor] == 0) {
          nodesWithZeroIndegrees.offer(neighbor);
        }
      }
    }
    if(count == numCourses){
      return toplogicalOrder;
    }return new int[0];
  }

  public List<List<Integer>> buildGraph (int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for(int i=0; i<numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    for(int[] prerequisite : prerequisites) {
      graph.get(prerequisite[1]).add(prerequisite[0]);
    }
    return graph;
  }
}

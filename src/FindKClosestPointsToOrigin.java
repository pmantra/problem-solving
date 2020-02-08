import java.util.*;

public class FindKClosestPointsToOrigin {

  public static void main(String...strings) {
    FindKClosestPointsToOrigin sol = new FindKClosestPointsToOrigin();
    int[][] points = {{0,1},{1,0}};
    int K = 2;
    sol.kClosest(points, K);
  }

  public int[][] kClosest(int[][] points, int K) {
    if(points.length == 0) return new int[0][0];
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> getDistanceFromOrigin(o2).compareTo(getDistanceFromOrigin(o1)));
    for(int[] point : points) {
      maxHeap.add(point);
      if(maxHeap.size() > K) {
        maxHeap.poll();
      }
    }
    return maxHeap.toArray(new int[K][2]);
  }

  private Double getDistanceFromOrigin (int[] point) {
    return Math.sqrt(Math.pow(point[0],2) + Math.pow(point[1],2));
  }

}

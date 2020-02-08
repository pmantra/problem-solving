import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    if(intervals.length == 0) return new int[0][0];
    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
    int[] prevInterval = intervals[0];
    List<int[]> retValList = new ArrayList<>();
    retValList.add(prevInterval);
    for(int i=1; i< intervals.length; i++) {
      int[] currInterval = intervals[i];
      if(currInterval[0] <= prevInterval[1]) {
        prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
      }else {
        prevInterval = currInterval;
        retValList.add(currInterval);
      }
    }
    return retValList.toArray(new int[0][]);
  }
}

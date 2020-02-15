import java.util.*;

public class MeetingScheduler {

  public static void main(String...strings) {
    MeetingScheduler sol = new MeetingScheduler();
    int[][] slots1 = {{0,45}};
    int[][] slots2 = {{40,50}};
    int duration = 5;
    System.out.println(sol.minAvailableDuration(slots1, slots2, duration));
  }

  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Arrays.sort(slots1, Comparator.comparingInt(s -> s[0]));
    Arrays.sort(slots2, Comparator.comparingInt(s -> s[0]));
    int len1 = slots1.length, len2 = slots2.length;
    int i = 0, j = 0;
    List<Integer> retVal = new ArrayList<>();
    while (i < len1 && j < len2) {
      int s1 = slots1[i][0];
      int e1 = slots1[i][1];
      int s2 = slots2[j][0];
      int e2 = slots2[j][1];
      int commonTime = Math.min(e1, e2) - Math.max(s1, s2);
      if (commonTime >= duration) {
        int start = Math.max(s1, s2);
        retVal.add(start);
        retVal.add(start + duration);
        return retVal;
      }
      else if(e1 <= e2) {
        i++;
      } else {
        j++;
      }
    }
    return retVal;
  }
}

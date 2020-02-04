import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

  public static void main(String...strings) {
    MeetingRooms sol = new MeetingRooms();
    int[][] input = {{6,10},{13,14},{12,14}};
    System.out.println(sol.canAttendMeetings(input));
    System.out.println(sol.minMeetingRooms(input));
  }

  public boolean canAttendMeetings(int[][] intervals) {
    if(intervals.length == 0) return true;
    Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
    int[] prevInterval = intervals[0];
    for(int i=1; i<intervals.length; i++) {
      int[] currInterval = intervals[i];
      if(prevInterval[1] > currInterval[0]) {
        return false;
      }
      prevInterval = currInterval;
    }
    return true;
  }

  public int minMeetingRooms(int[][] intervals) {
    if(intervals.length == 0) return 0;
    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i));
    minHeap.offer(intervals[0][1]);
    for(int i=1; i<intervals.length; i++) {
      Integer meetingRoomEndTime = minHeap.peek();
      if(meetingRoomEndTime == null || meetingRoomEndTime > intervals[i][0]) {
        //meeting room not available
        minHeap.offer(intervals[i][1]);
      } else {
        //meeting has ended
        minHeap.poll();
        minHeap.offer(intervals[i][1]);
      }
    }
    return minHeap.size();
  }
}

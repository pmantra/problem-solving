import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {

  public static void main(String...strings) {
    Interval i1 = new Interval(1,2);
    Interval i2 = new Interval(3,4);
    List<Interval> e1List = new ArrayList<>();
    e1List.add(i1);
    e1List.add(i2);

    Interval i3 = new Interval(6,7);
    List<Interval> e2List = new ArrayList<>();
    e2List.add(i3);

    Interval i4 = new Interval(9,10);
    List<Interval> e3List = new ArrayList<>();
    e3List.add(i4);

    List<List<Interval>> input = new ArrayList<>();
    input.add(e1List);
    input.add(e2List);
    input.add(e3List);

    EmployeeFreeTime sol = new EmployeeFreeTime();
    System.out.println(sol.employeeFreeTime(input));
  }

  static class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  }
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    //merge all intervals and check for freetime
    List<Interval> allIntervals = new ArrayList<>();
    for(List<Interval> employeeIntervalList : schedule) {
      allIntervals.addAll(employeeIntervalList);
    }
    allIntervals.sort(Comparator.comparingInt(i -> i.start));
    List<Interval> merged = mergeIntervals(allIntervals);
    return findFreeTime(merged);
  }

  private List<Interval> mergeIntervals (List<Interval> intervals) {
    if(intervals.size() == 0) return Collections.emptyList();
    List<Interval> merged = new ArrayList<>();
    Interval prev = intervals.get(0);
    merged.add(prev);
    for(int i=1; i<intervals.size(); i++) {
      Interval curr = intervals.get(i);
      if(curr.start <= prev.end) {
        prev.end = Math.max(prev.end, curr.end);
      }else {
        merged.add(curr);
        prev = curr;
      }
    }
    return merged;
  }
  private List<Interval> findFreeTime (List<Interval> intervals) {
    if(intervals.size() <= 1) return Collections.emptyList();
    List<Interval> retVal = new ArrayList<>();
    Interval prev = intervals.get(0);
    for(int i=1; i<intervals.size(); i++) {
      Interval current = intervals.get(i);
      if(prev.end < current.start) {
        retVal.add(new Interval(prev.end, current.start));
      }
      prev = current;
    }
    return retVal;
  }
}


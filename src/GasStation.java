import java.util.ArrayList;
import java.util.List;

public class GasStation {

  public static void main(String...strings) {
    int[] gas = {2};
    int[] cost = {2};
    GasStation sol = new GasStation();
    System.out.println(sol.canCompleteCircuit(gas, cost));
  }

  public int canCompleteCircuit(int[] gas, int[] cost) {
    if(gas.length == 0 || cost.length == 0) return -1;
    if(gas.length != cost.length) return -1;
    List<Integer> startingIndexList = new ArrayList<>();
    for(int i=0; i<gas.length; i++) {
      int gasAtIndex = gas[i];
      int costAtIndex = cost[i];
      if(gasAtIndex >= costAtIndex) {
        startingIndexList.add(i);
      }
    }
    int retVal = -1;
    for(int startingIndex : startingIndexList) {
      int i = startingIndex;
      int availableGas = 0;
      int nextIndex = -1;
      while (nextIndex != startingIndex) {
        availableGas += gas[i];
        int costAtIndex = cost[i];
        if(availableGas >= costAtIndex) {
          availableGas -= costAtIndex;
          i = i == gas.length-1 ? 0 : i+1;
          nextIndex = i;
        }
        else {
          break;
        }
      }
      if(nextIndex == startingIndex) {
        return startingIndex;
      }
    }
    return retVal;
  }
}

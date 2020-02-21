import java.util.*;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> retVal = new HashSet<>();
    Arrays.sort(nums);
    for(int i=0; i<nums.length; i++) {
      int j = i+1, k = nums.length-1;
      while(j < k) {
        if(nums[i] + nums[j] + nums[j] == 0) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(nums[k]);
          retVal.add(list);
        }
      }
    }
    return new ArrayList<>(retVal);
  }
}

import java.util.*;

public class Permutations {

  public static void main(String...strings) {
    Permutations sol = new Permutations();
    int[] nums = {1,2,3};
    sol.permute(nums);
  }

  public List<List<Integer>> permute(int[] nums) {
    if(nums.length == 0) return Collections.emptyList();
    Integer[] array = new Integer[nums.length];
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    Arrays.fill(used, false);
    helper(nums, array, 0, result, used);
    return result;
  }

  public void helper (int[] nums, Integer[] array, int pos, List<List<Integer>> result, boolean[] used) {
    if(pos == nums.length) {
      result.add(new ArrayList<>(Arrays.asList(array)));
      return;
    }
    for(int i=0; i<nums.length; i++) {
      if(!used[i]) {
        array[pos] = nums[i];
        used[i] = true;
        helper(nums, array, pos+1, result, used);
        used[i] = false;
      }
    }
  }
}

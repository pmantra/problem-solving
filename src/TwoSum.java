import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String... strings) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    System.out.println(Arrays.toString(twoSumHashMap(nums, target)));
    System.out.println(Arrays.toString(twoSum(nums, target)));
    int[] A = {34,23,1,24,75,33,54,8};
    int K = 60;
    System.out.println(twoSumLessThanK(A,K));
    System.out.println(Arrays.toString(twoSumClosest(A,K)));
  }

  public static int[] twoSumHashMap(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    //O(N)
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    //O(N)
    for (int i = 0; i < nums.length; i++) {
      int other = target - nums[i];
      if (map.containsKey(other) && map.get(other) != i) {
        return new int[]{nums[i], other};
      }
    }
    return new int[]{};
  }

  public static int[] twoSum(int[] nums, int target) {
    Arrays.sort(nums); //O(NLogN)
    int i = 0, j = nums.length-1;
    while (i < j) { //O(LogN)
      int sum = nums[i] + nums[j];
      if(sum == target) {
        //exactly one answer
        return new int[]{nums[i], nums[j]};
      }
      if(sum < target) {
        i++;
      }else {
        j--;
      }
    }
    return new int[]{};
  }

  public static int twoSumLessThanK(int[] A, int K) {
    Arrays.sort(A);
    int max = -1;
    int i = 0, j = A.length-1;
    while (i < j) {
      int sum = A[i] + A[j];
      if(sum < K) {
        max = Math.max(max, sum);
        i++;
      }
      else if(sum == K) {
        i++;
        j--;
      } else {
        j--;
      }
    }
    return max;
  }

  public static int[] twoSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int i = 0, j = nums.length-1;
    int min = Integer.MAX_VALUE;
    int[] retVal = new int[2];
    while (i != j) {
      int sum = nums[i] + nums[j];
      if(sum == target) {
        return new int[]{nums[i], nums[j]};
      }
      int diff = Math.abs(target-sum);
      if(diff < min) {
        min = diff;
        retVal = new int[]{nums[i], nums[j]};
      }
      if(sum < target) {
        i++;
      } else {
        j--;
      }
    }
    return retVal;
  }
}

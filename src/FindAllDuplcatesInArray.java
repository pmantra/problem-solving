import java.util.ArrayList;
import java.util.List;

public class FindAllDuplcatesInArray {

  public static void main(String...strings) {
    FindAllDuplcatesInArray sol = new FindAllDuplcatesInArray();
    int[] nums = {4,3,2,7,8,2,3,1};
    System.out.println(sol.findDuplicates(nums));
  }

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for(int i=0; i<nums.length; i++) {
      int curr = nums[i];
      System.out.println("curr: "+curr);
      int index = Math.abs(curr)-1;
      System.out.println("index: "+index);
      if(nums[index] < 0) {
        System.out.println("index+1: "+(index+1));
        result.add(index+1);
      }else {
        nums[index] *= -1;
      }
    }
    return result;
  }
}

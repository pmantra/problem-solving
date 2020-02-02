import java.util.Arrays;

public class ProductOfArrayExceptSelf {

  public static void main(String...strings) {
    ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();
    int[] nums = {1,2,3,4};
    System.out.println(Arrays.toString(sol.productExceptSelf(nums)));
  }

  /**
   * time - O(N)
   * space - O(N)
   * @param nums
   * @return
   */
  public int[] productExceptSelf(int[] nums) {
    //Product(Product(all elements left of nums[i]), Product(all elements right of nums[i]))
    //Product of left elements
    int[] leftProductArray = new int[nums.length];
    leftProductArray[0] = 1;
    for(int i=1; i<nums.length; i++) {
      leftProductArray[i] = leftProductArray[i-1] * nums[i-1];
    }
    //Product of right elements
    int[] rightProductArray = new int[nums.length];
    rightProductArray[nums.length-1] = 1;
    for(int i=nums.length-2; i>=0; i--) {
      rightProductArray[i] = rightProductArray[i+1] * nums[i+1];
    }
    //final product - reuse left array
    for(int i=0; i<nums.length; i++) {
      leftProductArray[i] = leftProductArray[i] * rightProductArray[i];
    }
    return leftProductArray;
  }
}

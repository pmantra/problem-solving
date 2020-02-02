import java.util.HashMap;
import java.util.Map;

public class NumbersWithEqualDigitSum {

  public static void main(String...strings) {
    NumbersWithEqualDigitSum sol = new NumbersWithEqualDigitSum();
    int[] A = {51,71,17,42};
    //int[] A = {42,33,60};
    //int[] A = {51,32,43};
    System.out.println(sol.solution(A));
  }

  public int solution (int[] A) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxSum = -1;
    for(int num : A) { //T->O(N)
      int sumOfDigits = getSumOfDigits(num);
      Integer maxNum = map.get(sumOfDigits);
      if(maxNum != null) {
        //sum the max 2 num that add up to same digit
        maxSum = Math.max(maxSum, maxNum + num);
      }
      //put max of num that add up to same digit
      map.put(sumOfDigits, Math.max(map.getOrDefault(sumOfDigits, 0), num)); //S->O(N)
    }
    return maxSum;
  }

  private int getSumOfDigits (int num) {
    int sum = 0;
    while (num > 0) {
      sum = sum + num%10;
      num = num/10;
    }
    return sum;
  }
}

import java.util.Arrays;

public class FindTwoMissingNumbers {

  public static void main(String...strings) {
    FindTwoMissingNumbers sol = new FindTwoMissingNumbers();
    int n = 4;
    int[] array = {1,2};
    System.out.println(Arrays.toString(sol.findTwoMissingNumbers(n, array)));
  }

  public int[] findTwoMissingNumbers (int n, int[] array) {
    if(n == 0) return new int[]{};
    int sumOfN = n * (n+1)/2;
    int sumOfArray = Arrays.stream(array).reduce(0, Integer::sum);
    int sumOfMissingNumbers = (sumOfN - sumOfArray);
    int k = sumOfMissingNumbers/2;
    int sumOfK = k * (k+1)/2;
    int sumOfKArray = 0;
    for(int num : array) {
      if(num <= k) {
        sumOfKArray += num;
      } else {
        break;
      }
    }
    int missingNum1 = sumOfK - sumOfKArray;
    int missingNum2 = sumOfMissingNumbers - missingNum1;
    return new int[] {missingNum1, missingNum2};
  }
}

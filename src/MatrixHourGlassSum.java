import java.util.Arrays;

public class MatrixHourGlassSum {

  public static void main(String...strings) {
    MatrixHourGlassSum sol = new MatrixHourGlassSum();
    int[][] input = {
      {1, 1, 1, 0, 0, 0},
      {0, 1, 0, 0, 0, 0},
      {1, 1, 1, 0, 0, 0},
      {0, 0, 2, 4, 4, 0},
      {0, 0, 0, 2, 0, 0},
      {0, 0, 1, 2, 4, 0}
    };
    System.out.println(sol.hourglassSum(input));
  }

  // Complete the hourglassSum function below.
  public int hourglassSum(int[][] arr) {
    int numRows = arr.length;
    int numColumns = arr[0].length;
    int max = Integer.MIN_VALUE;
    for(int i=0; i<numRows-2; i++) {
      for(int j=0; j<numColumns-2; j++) {
        int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] +
            arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
        max = Math.max(max, sum);
      }
    }
    return max;
  }
}

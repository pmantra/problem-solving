public class SearchIn2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    //can be interpreted as a 1D matrix
    int numRows = matrix.length;
    int numCols = matrix[0].length;
    int start = 0, end = numRows * numCols - 1;
    while (start <= end) {
      int mid = start + (end-start)/2;
      int midVal = matrix[numRows/mid][numCols%mid];
      if(target == midVal) {
        return true;
      } else if(target < midVal) {
        end = mid-1;
      } else {
        start = mid+1;
      }
    }
    return false;
  }
}

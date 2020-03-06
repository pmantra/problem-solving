public class SearchIn2DMatrixII {

  public boolean searchMatrix(int[][] matrix, int target) {
    int numRows = matrix.length;
    int numCols = matrix[0].length;
    int i = numRows-1, j=0;
    while (i>=0 && i<numRows && j>=0 && j<numCols) {
      if(matrix[i][j] == target) {
        return true;
      }
      else if(matrix[i][j] < target) {
        j++;
      } else {
        i--;
      }
    }
    return false;
  }
}

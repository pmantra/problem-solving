public class MineSweeper {

  public char[][] updateBoard(char[][] board, int[] click) {
    if(click == null || click.length == 0) return board;
    mineSweeperHelper (board, click);
    return board;
  }

  private void mineSweeperHelper (char[][] board, int[] click) {
    int row = click[0], col = click[1];
    char clickedCell = board[row][col];
    if(clickedCell == 'M') {
      //change it to X
      board[row][col] = 'X';
    } else if(clickedCell == 'E'){
      int[][] directions = {
        {row-1, col}, {row+1, col}, {row, col-1}, {row, col+1},
        {row-1, col-1}, {row+1, col-1}, {row-1, col+1}, {row+1, col+1}
      };
      int numAdjacentMines = 0;
      for(int[] direction : directions) {
        int nRow = direction[0], nCol = direction[1];
        if(nRow >=0 && nRow < board.length &&
          nCol >=0 && nCol < board[0].length) {
          if(board[nRow][nCol] == 'M') {
            ++numAdjacentMines;
          }
        }
      }
      if(numAdjacentMines == 0) {
        //1.set the cell to blank
        board[row][col] = 'B';
        //2. recursively reveal all of its adjacent unrevealed squares
        for(int[] direction : directions) {
          int nRow = direction[0], nCol = direction[1];
          if(nRow >=0 && nRow < board.length &&
            nCol >=0 && nCol < board[0].length) {
            if(board[nRow][nCol] == 'M' || board[nRow][nCol] == 'E') {
              int[] nClick = {nRow, nCol};
              mineSweeperHelper(board, nClick);
            }
          }
        }
      }else {
        //change it to a digit representing number of adjacent mines
        board[row][col] = (char) (numAdjacentMines + '0');
      }
    }
  }
}

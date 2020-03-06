public class MinSwapToSortArray {

  public int getMinSwaps(int[] arr) {
    if(arr.length == 0) return 0;
    int count = 0;
    //arr to keep track of elements visited
    boolean[] visited = new boolean[arr.length+1]; //numbers are from 1 to n
    for(int i=1; i<visited.length; i++) {
      if(!visited[i]) {
        visited[i] = true;
        //if the element is already sorted
        if(i == arr[i-1]) {
          continue;
        } else {
          int unsortedNum = arr[i-1];
          while (!visited[unsortedNum]) {
            visited[unsortedNum] = true;
            unsortedNum = arr[unsortedNum-1];
            ++count;
          }
        }
      }
    }
    return count;
  }
}

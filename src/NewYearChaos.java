public class NewYearChaos {

  public static void main(String...strings) {
    NewYearChaos sol = new NewYearChaos();
    int[] input = {2,1,5,3,4};
    sol.minimumBribes(input);

  }
  public void minimumBribes(int[] q) {
    if(q.length == 0) return;
    int count = 0;
    for(int i=q.length-1; i>=0 ; i--) {
      if(q[i] - (i+1) > 2) {
        System.out.println("Too chaotic");
        return;
      }
      for(int j=Math.max(0, q[i]-2); j<i; j++) {
        if(q[j] > q[i]) {
          ++count;
        }
      }
    }
    System.out.println(count);
  }
}

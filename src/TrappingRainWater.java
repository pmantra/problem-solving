public class TrappingRainWater {

  public static void main(String...strings) {
    TrappingRainWater sol = new TrappingRainWater();
    int[] height = {1};
    System.out.println(sol.trap(height));
    System.out.println(sol.trapWithDP(height));
  }

  //Bruteforce
  public int trap(int[] height) {
    int retVal = 0;
    for(int i=0; i<height.length; i++) {
      int maxLeft = 0, maxRight = 0;
      int iLeft = i, iRight = i;
      while (iLeft > 0) {
        maxLeft = Math.max(maxLeft, height[iLeft]);
        iLeft--;
      }
      while (iRight < height.length) {
        maxRight = Math.max(maxRight, height[iRight]);
        iRight++;
      }
      retVal = retVal + Math.min(maxLeft, maxRight) - height[i];
    }
    return retVal;
  }

  //DP
  public int trapWithDP(int[] height) {
    if(height.length == 0) return 0;
    int retVal = 0;
    int[] maxWaterLeft = new int[height.length];
    int maxLeft = 0;
    for(int i=height.length-1; i>=0; i--) {
      maxLeft = Math.max(maxLeft, height[i]);
      maxWaterLeft[i] = maxLeft;
    }

    int[] maxWaterRight = new int[height.length];
    int maxRight = 0;
    for(int i=0; i<height.length; i++) {
      maxRight = Math.max(maxRight, height[i]);
      maxWaterRight[i] = maxRight;
    }

    for(int i=0; i<height.length; i++) {
      retVal = retVal + Math.min(maxWaterLeft[i], maxWaterRight[i]) - height[i];
    }
    return retVal;
  }
}

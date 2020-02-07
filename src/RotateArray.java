public class RotateArray {
  public int[] rotLeft(int[] a, int d) {
    if(a == null || a.length == 0) return a;
    if(d == 0) return a;
    int n = a.length;
    int j = 0;
    int[] rotated = new int[n];
    for(int i=d; i<n; i++) {
      rotated[j++] = a[i];
    }
    for(int i=0; i<d; i++) {
      rotated[j++] = a[i];
    }
    return rotated;
  }
}

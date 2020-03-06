public class DavisStaircase {

  static int stepPerms(int n) {
    if(n <= 0) return 0;
    if(n <= 2) return n;
    if(n == 3) return 4;
    return stepPerms(n-1) + stepPerms(n-2) + stepPerms(n-3);
  }

  public static void main(String...strings) {
    System.out.println(stepPerms(5));
  }
}

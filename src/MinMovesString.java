import java.util.HashMap;
import java.util.Map;

public class MinMovesString {
  public static void main(String...strings) {
    MinMovesString sol = new MinMovesString();
    String string = "baaabbaabbba";
    System.out.println(sol.solution(string));
  }

  public int solution (String string) {
    int moves = 0;
    for(int i=0; i<string.length(); i++) {
      int count = 1;
      while(i+1 < string.length() && string.charAt(i) == string.charAt(i+1)) {
        ++count;
        i++;
      }
      moves += count/3;
    }
    return moves;
  }
}

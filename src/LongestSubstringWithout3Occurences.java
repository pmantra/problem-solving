public class LongestSubstringWithout3Occurences {

  public static void main(String...strings) {
    String s = "bbaaababab";
    LongestSubstringWithout3Occurences sol = new LongestSubstringWithout3Occurences();
    System.out.println(sol.getLongestSubString(s));
  }

  public String getLongestSubString(String s) {
    int max = Integer.MIN_VALUE;
    int curr = 0, start = 0, end = 1;
    int count = 0;
    String retVal = "";
    while (end < s.length()) {
      if(s.charAt(curr) == s.charAt(end)) {
        count++;
        if(count == 2) {
          if(end-start > max) {
            max = end-start;
            retVal = s.substring(start, end);
          }
          start = curr;
        }
      }else {
        count=0;
      }
      ++end;
      ++curr;
    }
    if(end-start > max) {
      retVal = s.substring(start, end);
    }
    return retVal;
  }
}

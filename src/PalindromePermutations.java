public class PalindromePermutations {

  public static void main(String...strings) {
    PalindromePermutations sol = new PalindromePermutations();
    System.out.println(sol.canPermutePalindrome("racecar"));
    System.out.println(sol.longestPalindrome("abccccdd"));
  }

  public boolean canPermutePalindrome(String s) {
    int[] map = new int[128];
    int numOdd = 0;
    for(char c : s.toCharArray()) {
      map[(int) c]++;
      if(map[(int) c]%2 != 0) {
        ++numOdd;
      }else {
        --numOdd;
      }
    }
    return numOdd <= 1;
  }

  /**
   * Given a string which consists of lowercase or uppercase letters,
   * find the length of the longest palindromes that can be built with those letters.
   *
   * This is case sensitive, for example "Aa" is not considered a palindrome here
   * @param s
   * @return
   */
  public int longestPalindrome(String s) {
    int length = 0;
    int oddCount = 0;
    int[] map = new int[128];
    for(char c : s.toCharArray()) {
      map[(int)c]++;
      if(map[(int)c]%2 !=0) {
        ++oddCount;
      }else {
        length+=2;
        --oddCount;
      }
    }
    if(oddCount > 0) {
      return length+1;
    }
    return length;
  }
}

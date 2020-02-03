import java.util.*;

public class PhoneNumberLetterCombinations {

  public static void main(String...strings) {
    String input = "23";
    PhoneNumberLetterCombinations sol = new PhoneNumberLetterCombinations();
    System.out.println(sol.letterCombinations(input));
  }

  Map<Integer, String> map;
  public List<String> letterCombinations(String digits) {
    if(digits == null || digits.length() == 0) return Collections.emptyList();
    List<String> result = new ArrayList<>();
    char[] buffer = new char[256];
    recursiveHelper(digits, buffer, 0, result);
    return result;
  }

  private void recursiveHelper (String digits, char[] buffer, int pos, List<String> result) {
    if(pos == digits.length()) {
      result.add(new String(buffer).trim());
      return;
    }
    String characters = getCharactersByNumber(digits.charAt(pos) -'0');
    for(int i=0; i<characters.length(); i++) {
      buffer[pos] = characters.charAt(i);
      recursiveHelper(digits, buffer, pos+1, result);
    }
  }

  private String getCharactersByNumber (int num) {
    if(map == null) {
      map = new HashMap<>();
      map.put(2, "abc");
      map.put(3, "def");
      map.put(4, "ghi");
      map.put(5, "jkl");
      map.put(6, "mno");
      map.put(7, "pqrs");
      map.put(8, "tuv");
      map.put(9, "wxyz");
    }
    return map.get(num);
  }
}

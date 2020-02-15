import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringCompression {

  public static void main(String...strings) {
    StringCompression sol = new StringCompression();
    char[] input = {'a', 'a','a','a','a','a',
      'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b',
      'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
    System.out.println(sol.compress(input));
  }

  public int compress(char[] chars) {
    int count=1, write = 0;
    for(int i=0; i<chars.length-1; i++) {
      if(chars[i] == chars[i+1]) {
        ++count;
      }else {
        chars[write++] = chars[i];
        if(count > 1 && count < 10) {
          chars[write++] = (char)(count + '0');
        }else if(count >= 10) {
          for(char c : getNumberCharArray(count)) {
            chars[write++] = c;
          }
        }
        count = 1;
      }
    }
    if(count == 1) {
      chars[write++] = chars[chars.length-1];
    }
    else if(count > 1) {
      chars[write++] = chars[chars.length-1];
      if(count < 10) {
        chars[write++] = (char)(count + '0');
      }else if(count >= 10) {
        for(char c : getNumberCharArray(count)) {
          chars[write++] = c;
        }
      }
    }
    System.out.println("chars before: "+Arrays.toString(chars));
    chars = Arrays.copyOf(chars, write);
    System.out.println("chars after: "+Arrays.toString(chars));
    return chars.length;
  }


  public List<Character> getNumberCharArray (int num) {
    List<Character > retVal = new ArrayList<>();
    while (num >0) {
      int digit = num%10;
      retVal.add((char)(digit+'0'));
      num = num/10;
    }
    Collections.reverse(retVal);
    return retVal;
  }
}

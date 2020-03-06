import java.util.*;

public class WordLadderII {

  public static void main(String...strings) {
    WordLadderII sol = new WordLadderII();
    String beginWord = "hit";
    String endword = "cog";
    String[] wordList = {
      "hot","dot","dog","lot","log","cog"
    };
    System.out.println(sol.findLadders(beginWord, endword, Arrays.asList(wordList)));
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    if(wordList.size() == 0) return new ArrayList<>();
    if(!wordList.contains(endWord)) return new ArrayList<>();
    Map<String, List<String>> graph = buildWordGraph(wordList);
    Map<String, List<String>> prevMap = new HashMap<>();
    Map<String, Boolean> visited = new HashMap<>();

    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    List<List<String>> retVal = new ArrayList<>();
    while(!queue.isEmpty()) {
      String word = queue.poll();
      for(int i=0; i<word.length(); i++) {
        String left = word.substring(0,i), right = word.substring(i+1);
        String key = left +'*'+right;
        List<String> wordsMatching = graph.get(key);
        if(wordsMatching != null) {
          for(String wordMatching : wordsMatching) {
            List<String> prevList = prevMap.getOrDefault(wordMatching, new ArrayList<>());
            prevList.add(wordMatching);
            prevMap.put(word, prevList);
            if(wordMatching.equals(endWord)) {
              //retVal.add(getSequence(prevMap, beginWord, endWord));
              visited.put(wordMatching, false);
            }else {
              if(!visited.containsKey(wordMatching)) {
                visited.put(wordMatching, true);
                queue.offer(wordMatching);
              }
            }
          }
        }
      }
    }
    return retVal;
  }

  private Map<String,List<String>> buildWordGraph(List<String> wordList) {
    Map<String,List<String>> graph = new HashMap<>();
    //O(m*s) m->num of words s->avg word length
    for(String word : wordList) {
      for(int i=0; i<word.length(); i++) {
        String left = word.substring(0,i);
        String right = word.substring(i+1);
        String key = left+'*'+right;
        List<String> list = graph.getOrDefault(key, new ArrayList<>());
        list.add(word);
        graph.put(key, list);
      }
    }
    return graph;
  }

  private List<String> getSequence (Map<String, String> map, String beginWord, String endWord) {
    Stack<String> stack = new Stack<>();
    stack.push(endWord);
    String parent = endWord;
    while (parent != null && !parent.equals(beginWord)) {
      parent = map.get(parent);
      stack.push(parent);
    }
    List<String> retVal = new ArrayList<>();
    while (!stack.isEmpty()) {
      retVal.add(stack.pop());
    }
    return retVal;
  }
}

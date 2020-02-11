import javafx.util.Pair;

import java.util.*;

public class WordLadder {

  public static void main(String...strings) {
    WordLadder sol = new WordLadder();
    String beginWord = "hit";
    String endword = "cog";
    String[] wordList = {
      "hot","dot","dog","lot","log","cog"
    };
    System.out.println(sol.ladderLength(beginWord, endword, Arrays.asList(wordList)));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if(!wordList.contains(endWord)) return 0;
    //keep track of visited nodes
    Map<String, Boolean> visited = new HashMap<>();
    //key is intermediate word with one char difference, values match the pattern in key
    Map<String, List<String>> wordGraph = getWordGraph(wordList);
    Queue<Pair<String, Integer>> wordQueue = new LinkedList<>();
    wordQueue.add(new Pair<>(beginWord, 1));
    //BFS
    while (!wordQueue.isEmpty()) {
      //maintain level in Pair and increment for every word added in queue
      Pair<String, Integer> node = wordQueue.remove();
      String word = node.getKey();
      int level = node.getValue();
      for(int i=0; i<word.length(); i++) {
        //transform the word in queue and get matching words
        String left = word.substring(0,i), right = word.substring(i+1);
        String key = left +'*'+right;
        List<String> wordsMatching = wordGraph.get(key);
        if(wordsMatching != null) {
          for(String wordMatching : wordsMatching) {
            //check if its the end
            if(wordMatching.equals(endWord)) {
              return level+1;
            }
            //if not already visited add it to the queue and update level
            else if(!visited.containsKey(wordMatching)) {
              visited.put(wordMatching, true);
              wordQueue.offer(new Pair<>(wordMatching, level+1));
            }
          }
        }
      }
    }
    return 0;
  }

  private Map<String, List<String>>  getWordGraph (List<String> wordList) {
    Map<String, List<String>> wordGraph = new HashMap<>();
    for(String word : wordList) {
      for(int i=0; i<word.length(); i++) {
        String left = word.substring(0,i);
        String right = word.substring(i+1);
        String key = left +'*'+right;
        List<String> list = wordGraph.getOrDefault(key, new ArrayList<>());
        list.add(word);
        wordGraph.put(key, list);
      }
    }
    return wordGraph;
  }
}

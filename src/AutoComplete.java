import java.util.ArrayList;
import java.util.List;

public class AutoComplete {

  static class Trie {
    TrieNode root;

    Trie () {
      root = new TrieNode('*');
    }

    /**
     * Adds new word in the trie
     * @param word
     */
    public void addWord (String word) {
      TrieNode currentNode = root;
      for(char c : word.toCharArray()) {
        TrieNode matchingNode = findMatchingNode(c, currentNode);
        if(matchingNode == null) {
          matchingNode = new TrieNode(c);
          currentNode.children.add(matchingNode);
          currentNode = matchingNode;
        }else {
          currentNode = matchingNode;
        }
      }
      currentNode.isWord = true;
    }

    /**
     * Utility method returning node matching a given char val in the trie
     * @param val
     * @param node
     * @return
     */
    private TrieNode findMatchingNode (char val, TrieNode node) {
      for (TrieNode tn : node.children) {
        if(tn.val == val) {
          return tn;
        }
      }
      return null;
    }

    /**
     * Navigate to the trie node in the trie matching the given prefix
     * @param prefix
     * @return
     */
    public List<String> search (String prefix) {
      List<String> matchingWords = new ArrayList<>();
      char[] buffer = new char[256];
      int pos = 0;
      TrieNode currentNode = root;
      for(char c : prefix.toCharArray()) {
        TrieNode matchingNode = findMatchingNode(c, currentNode);
        if(matchingNode != null) {
          currentNode = matchingNode;
          buffer[pos++] = c;
        }
      }
      searchHelper(matchingWords, currentNode, buffer, pos);
      return matchingWords;
    }

    /**
     * DFS to find all words matching prefix
     * @param matchingWords
     * @param node
     * @param buffer
     * @param pos
     */
    private void searchHelper (List<String> matchingWords, TrieNode node, char[] buffer, int pos) {
      if(node.isWord) {
        matchingWords.add(new String(buffer).trim().substring(0, pos));
      }
      if(node.children.size() == 0) {
        return;
      }
      for(TrieNode n : node.children) {
        buffer[pos] = n.val;
        searchHelper(matchingWords, n, buffer, pos+1);
      }
    }
  }

  static class TrieNode {
    char val;
    List<TrieNode> children;
    boolean isWord;

    TrieNode (char val) {
      this.val = val;
      this.children = new ArrayList<>();
      this.isWord = false;
    }
  }

  public static void main(String...strings) {
    Trie trie = new Trie();
    //String[] words = {"mobile", "money", "moneypot", "mouse", "mousepad"};
    String[] words = {"oath","pea","eat","rain"};
    for(String word : words) {
      trie.addWord(word);
    }
    System.out.println("search results: "+trie.search("oa"));
  }
}

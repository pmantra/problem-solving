import java.util.*;

public class WordSearchII {

  public List<String> findWords(char[][] board, String[] words) {
    if(board == null || board.length == 0) return Collections.emptyList();
    Trie trie = new Trie();
    //build trie with all words
    for(String word : words) {
      trie.addWord(word);
    }
    //make word patterns and check for words in the grid using dfs
    boolean[][] visited = new boolean[board.length][board[0].length];
    char[] buffer = new char[256];
    int pos = 0;
    Set<String> result = new HashSet<>();
    for(int i=0; i<board.length; i++) {
      for(int j=0; j<board[i].length; j++) {
        if(!visited[i][j]) {
          traverseBoardWithDFS(board, i, j, pos, buffer, visited, trie, trie.root, result);
        }
      }
    }
    return new ArrayList<>(result);
  }

  private void traverseBoardWithDFS (char[][] board,
                                     int row,
                                     int col,
                                     int pos,
                                     char[] buffer,
                                     boolean[][] visited,
                                     Trie trie,
                                     TrieNode node,
                                     Set<String> result) {
    if(node == null) {
      return;
    }
    if(node.isWord) {
      result.add(new String(buffer).trim().substring(0, pos));
    }
    if(row < 0 || row >= board.length)
      return;
    if(col < 0 || col >= board[0].length)
      return;
    if(visited[row][col])
      return;

    TrieNode matchingNode = trie.getMatchingNode(board[row][col], node);
    visited[row][col] = true;
    buffer[pos] = board[row][col];
    traverseBoardWithDFS(board, row-1, col, pos+1, buffer, visited, trie, matchingNode, result);
    traverseBoardWithDFS(board, row+1, col, pos+1, buffer, visited, trie, matchingNode, result);
    traverseBoardWithDFS(board, row, col-1, pos+1, buffer, visited, trie, matchingNode, result);
    traverseBoardWithDFS(board, row, col+1, pos+1, buffer, visited, trie, matchingNode, result);
    visited[row][col] = false;
  }

  static class Trie {
    TrieNode root;

    Trie () {
      root = new TrieNode('*');
    }

    private TrieNode getMatchingNode (char c, TrieNode node) {
      for(TrieNode n : node.children) {
        if(n.val == c){
          return n;
        }
      }
      return null;
    }

    void addWord (String word) {
      TrieNode currentNode = root;
      for(char c : word.toCharArray()) {
        TrieNode matchingNode = getMatchingNode(c, currentNode);
        if(matchingNode == null) {
          matchingNode = new TrieNode(c);
          currentNode.children.add(matchingNode);
        }
        currentNode = matchingNode;
      }
      currentNode.isWord = true;
    }

    /*List<String> getWordsMatchingCriteria (String criteria) {
      if(criteria == null || criteria.trim().length() == 0)
        return Collections.emptyList();
      List<String> result = new ArrayList<>();
      char[] buffer = new char[256];
      int pos = 0;
      TrieNode currentNode = root;
      for(char c : criteria.toCharArray()) {
        TrieNode matchingNode = getMatchingNode(c, currentNode);
        if(matchingNode != null) {
          currentNode = matchingNode;
          buffer[pos++] = c;
        }
      }
      dfsSearch(currentNode, pos, buffer, result);
      return result;
    }*/

    /*private void dfsSearch (TrieNode node, int pos, char[] buffer, List<String> result) {
      if(node.isWord) {
        result.add(new String(buffer).trim().substring(0, pos));
      }
      if(node.children.size() == 0) {
        return;
      }
      for(TrieNode n : node.children) {
        buffer[pos] = n.val;
        dfsSearch(n, pos+1, buffer, result);
      }
    }*/
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
    WordSearchII sol = new WordSearchII();
    /*String[] words = {"oath","pea","eat","rain"};
    char[][] board = {
      {'o','a','a','n'},
      {'e','t','a','e'},
      {'i','h','k','r'},
      {'i','f','l','v'}
    };
    */

    String[] words = {"a"};
    char[][] board = {{'a'}};
    System.out.println(sol.findWords(board, words));
  }
}

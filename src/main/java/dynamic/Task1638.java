package dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Task1638 {
    public static void main(String[] args) {
        System.out.println(new Task1638().countSubstrings("abe", "bbc"));
        System.out.println(new Task1638().countSubstrings("aba", "baba"));
        System.out.println(new Task1638().countSubstrings("ab", "bb"));
        System.out.println(new Task1638().countSubstrings("a", "b"));

    }

    public int countSubstrings(String first, String second) {
        int res = 0;
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                int miss = 0;
                for (int pos = 0; i + pos < first.length() && j + pos < second.length(); pos++){
                    if (first.charAt(i+pos) != second.charAt(j+pos) && ++miss > 1)
                        break;
                    res += miss;
                }
            }
        }

        return res;
    }

    public class Trie {
        private TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode current = root;

            for (char l: word.toCharArray()) {
                current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
                current.setEndOfWord(true);
            }
        }

        public boolean find(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.getChildren().get(ch);
                if (node == null) {
                    return false;
                }
                current = node;
            }
            return current.isEndOfWord();
        }

        public void delete(String word) {
            delete(root, word, 0);
        }

        private boolean delete(TrieNode current, String word, int index) {
            if (index == word.length()) {
                if (!current.isEndOfWord()) {
                    return false;
                }
                current.setEndOfWord(false);
                return current.getChildren().isEmpty();
            }
            char ch = word.charAt(index);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

            if (shouldDeleteCurrentNode) {
                current.getChildren().remove(ch);
                return current.getChildren().isEmpty();
            }
            return false;
        }

        public class TrieNode {
            private HashMap<Character, TrieNode> children;
            private String content;
            private boolean isWord;

            public TrieNode() {
                children = new HashMap<>();
            }

            public HashMap<Character, TrieNode> getChildren() {
                return children;
            }

            public boolean isEndOfWord() {
                return isWord;
            }

            public void setEndOfWord(boolean word) {
                isWord = word;
            }
        }
    }
}

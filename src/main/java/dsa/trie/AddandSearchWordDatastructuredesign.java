package dsa.trie;

public class AddandSearchWordDatastructuredesign {

    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public AddandSearchWordDatastructuredesign() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        return search(word, 0, node);
    }

    public boolean search(String word, int pos, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (pos == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(pos);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(word, pos + 1, node.children[i])) {
                    return true;
                }
            }
        } else {
            if (search(word, pos + 1, node.children[c - 'a'])) {
                return true;
            }
        }
        return false;
    }
}

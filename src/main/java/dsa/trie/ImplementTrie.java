package dsa.trie;

public class ImplementTrie {

    public static void main(String[] args){
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");
    }

    class TrieNode{
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the dsa.trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i =0; i<word.length();i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the dsa.trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i =0; i<word.length();i++){
            char c  = word.charAt(i);
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the dsa.trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i =0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

}


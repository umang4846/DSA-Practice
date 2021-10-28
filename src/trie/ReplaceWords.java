package trie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    //Approach 1
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(int i = 0; i<words.length; i++){
            for(int j = 1; j<=words[i].length();j++){
                String root = words[i].substring(0,j);
                if(set.contains(root)){
                    words[i] = root;
                }
            }
            sb.append(words[i] + " ");
        }
        return sb.substring(0,sb.length()-1);
    }


    //Approach 2
    public String replaceWords2(List<String> dictionary, String sentence) {
        String[] str = sentence.split(" ");
        Trie  trie = new Trie();
        for(String s : dictionary){
            trie.insert(s);
        }
        StringBuilder sb = new StringBuilder();
        for(String s : str){
            sb.append(trie.search(s)).append(" ");
        }
        return sb.toString().trim();
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode(){
            children = new TrieNode[26];
        }
    }

    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        public void insert(String s){
            TrieNode node = root;
            for(char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        public String search(String s){
            TrieNode node = root;
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                if(node.children[c - 'a'] == null){
                    return s;
                }else{
                    node = node.children[c - 'a'];
                    sb.append(c);
                    if(node.isWord){
                        break;
                    }
                }
            }
            return sb.toString();
        }

    }

}

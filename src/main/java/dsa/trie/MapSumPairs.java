package dsa.trie;

import java.util.HashMap;

public class MapSumPairs {

    //Approach 1;

   /* Map<String, Integer> map;
    *//** Initialize your data structure here. *//*
    public MapSumPairs() {
        map = new HashMap<>();
    }
    public void insert(String key, int val) {
        map.put(key,val);
    }
    public int sum(String prefix) {
        int ans = 0;
        for(String key : map.keySet()){
            if(key.startsWith(key)){
                ans += map.get(key);
            }
        }
        return ans;
    }*/

    //Approach 2
    public class Node{
        Node[] children = new Node[26];
        int score = 0;
    }

    Node root = new Node();
    HashMap<String, Integer> map;
    public MapSumPairs() {
        root = new Node();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int deltaVal = val - map.getOrDefault(key, 0);
        map.put(key, val);
        Node curr = root;
        for(int i = 0; i<key.length();i++){
            char ch = key.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
            curr.score = curr.score + deltaVal;
        }
    }

    public int sum(String prefix){
        Node curr = root;
        for(int i = 0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch - 'a'] == null){
                return 0;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.score;
    }


    public static void main(String[] args) {
        MapSumPairs mapSumPairs = new MapSumPairs();
        mapSumPairs.insert("apple",3);
        System.out.println(mapSumPairs.sum("apple"));
        mapSumPairs.insert("app",2);
        System.out.println(mapSumPairs.sum("ap"));

    }

}

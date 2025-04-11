package dsa.hashtable;

public class DesignHashSet {

    //Approach 1 Using big size of array
     boolean[] arr;
     //** Initialize your data structure here. *//*
    public DesignHashSet() {
        arr = new boolean[1000001];
    }

    public void add1(int key) {
        arr[key] = true;
    }

    public void remove1(int key) {
        arr[key] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains1(int key) {
        return arr[key];
    }

 }

//Approach 2 Using Trie
class TrieNode {
    boolean isNumber;
    TrieNode[] digits;

    TrieNode() {
        digits = new TrieNode[10];
    }
}
class DesignHashSetUsingTrie {

    TrieNode root;
    DesignHashSetUsingTrie() {
        root = new TrieNode();
    }

    void add(int key) {
        TrieNode cur = root;
        while (key != 0) {
            int digit = key % 10;
            if (cur.digits[digit] == null) {
                cur.digits[digit] = new TrieNode();
            }
            cur = cur.digits[digit];
            key = key / 10;
        }
        cur.isNumber = true;
    }

    void remove(int key) {
        TrieNode cur = root;
        while (key != 0) {
            int digit = key % 10;
            if (cur.digits[digit] == null) {
                return;
            }
            cur = cur.digits[digit];
            key = key / 10;
        }
        cur.isNumber = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    boolean contains(int key) {
        TrieNode cur = root;
        while (key != 0) {
            int digit = key % 10;
            if (cur.digits[digit] == null) {
                return false;
            }
            cur = cur.digits[digit];
            key = key / 10;
        }
        return cur.isNumber;
    }

   /* Consider the following set of processes and the length of the CPU burst time given in milliseconds.
    Process    Burst time(ms)
    P1           5
    P2           7
    P3           6
    P4           4
    Assume that processes being scheduled with Round Robin Scheduling Algorithm with Time Quantum 4ms.
    The waiting time for P4 is */

}

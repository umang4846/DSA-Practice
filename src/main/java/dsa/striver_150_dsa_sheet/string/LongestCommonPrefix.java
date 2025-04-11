package dsa.striver_150_dsa_sheet.string;

public class LongestCommonPrefix {

    //Approach 1
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        //   LongestCommonPrefix lcp = new LongestCommonPrefix();
        //    System.out.println(lcp.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        String[] strArr = new String[]{"flower", "flow", "flight"};
        for (int i = 0; i < strArr.length; i++)
            insert(strArr[i]);
        System.out.println(walkTrie(strArr.length));

    }

    // Trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        // isLeaf is true if the node represents
        // end of a word
        boolean isLeaf;
        int wordCount;

        // constructor
        public TrieNode() {
        }
    }

    static TrieNode root = new TrieNode();
    static int indexs;

    static void insert(String key) {
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl.wordCount++;

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isLeaf = true;
    }

    static String walkTrie(int stringSize) {
        TrieNode pCrawl = root;
        indexs = 0;
        String prefix = "";
        int wordCount = pCrawl.wordCount;
        while (wordCount == stringSize && pCrawl.isLeaf == false) {
            pCrawl = pCrawl.children[indexs];
            wordCount = pCrawl.wordCount;
            prefix += (char) ('a' + indexs);
        }
        return prefix;
    }
}

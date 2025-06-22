package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Name: 139. Word Break
 * Link: https://leetcode.com/problems/word-break/
 * Code Link: https://github.com/MAZHARMIK/Interview_DS_Algo/blob/master/DP/Word%20Break.cpp
 * */
public class WordBreak {
    int n;

    public static void main(String[] args) {

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(
                Arrays.asList("leet", "code")
        );
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    //Approach-1 (Recur + Memoization)
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        Boolean[] memo = new Boolean[s.length()];
        return solveRec(s, 0, wordDict, memo);
    }

    private boolean solveRec(String s, int idx, List<String> wordDict, Boolean[] memo) {
        if (idx == n) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (int endIdx = idx + 1; endIdx <= n; endIdx++) {

            String split = s.substring(idx, endIdx);

            if (wordDict.contains(split) && solveRec(s, endIdx, wordDict, memo)) {
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;

    }


}

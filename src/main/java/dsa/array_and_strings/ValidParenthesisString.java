package dsa.array_and_strings;

/*
678. Valid Parenthesis String
Link : https://leetcode.com/problems/valid-parenthesis-string/description/
*/

public class ValidParenthesisString {
    public static void main(String[] args) {
        ValidParenthesisString vps = new ValidParenthesisString();
        String s = "(*))";

        /*
            Approach 1 : Recursion
            Time complexity: O(3 ^ N)
            Space complexity: O(n)
        */
        //System.out.println(vps.checkValidStringRecursion(s));

        /*
            Approach 2 : Memoization
            Time complexity: O(N^2)
            Space complexity: O(N^2)
        */

        //  System.out.println(vps.checkValidStringMemo(s));

        /*
        Approach 3 : Greedy
        Time complexity: O(N)
        Space complexity: O(1)

        * */
        System.out.println(vps.checkValidStringGreedy(s));

    }


    public boolean checkValidStringRecursion(String s) {
        return dfsRec(0, 0, s);
    }

    private boolean dfsRec(int i, int open, String s) {
        if (open < 0) return false;
        if (i == s.length()) return open == 0;

        if (s.charAt(i) == '(') {
            return dfsRec(i + 1, open + 1, s);
        } else if (s.charAt(i) == ')') {
            return dfsRec(i + 1, open - 1, s);
        } else {
            return dfsRec(i + 1, open, s) ||
                    dfsRec(i + 1, open + 1, s) ||
                    dfsRec(i + 1, open - 1, s);
        }

    }

    public boolean checkValidStringMemo(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n + 1][n + 1];
        return dfsMemo(0, 0, s, memo);
    }

    private boolean dfsMemo(int i, int open, String s, Boolean[][] memo) {
        if (open < 0) return false;
        if (i == s.length()) return open == 0;

        if (memo[i][open] != null) return memo[i][open];

        boolean result;
        if (s.charAt(i) == '(') {
            result = dfsMemo(i + 1, open + 1, s, memo);
        } else if (s.charAt(i) == ')') {
            result = dfsMemo(i + 1, open - 1, s, memo);
        } else {
            result = (dfsMemo(i + 1, open, s, memo) ||
                    dfsMemo(i + 1, open + 1, s, memo) ||
                    dfsMemo(i + 1, open - 1, s, memo));
        }

        memo[i][open] = result;
        return result;

    }

    public boolean checkValidStringGreedy(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}
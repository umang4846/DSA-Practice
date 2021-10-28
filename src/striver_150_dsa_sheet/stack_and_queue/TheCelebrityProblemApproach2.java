package striver_150_dsa_sheet.stack_and_queue;

import java.util.Stack;

public class TheCelebrityProblemApproach2 {
    /*
        TC: O(n)
        SC: O(1)
    */
    public static void main(String[] args) {
        int[][] M = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};

        int celebIdx = celebrity(M, 4);

        if (celebIdx == -1)
            System.out.println("No celebrity found!");
        else {
            System.out.println(
                    "0-based celebrity index is : " + celebIdx);
        }
    }

    public static int celebrity(int[][] M, int n) {
        // This function returns the celebrity
        // index 0-based (if any)

        int i = 0, j = n - 1;
        while (i < j) {
            if (M[i][j] == 1) // i knows j
                i++;
            else // i don't know j, so j can't be a celebrity
                j--;
        }
        // i points to our celebrity candidate
        int candidate = i;

        // Now, all that is left is to check that whether
        // the candidate is actually a celebrity i.e: he is
        // known by everyone but he knows no one
        for (i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[i][candidate] == 0 || M[candidate][i] == 1)
                    return -1;
            }
        }
        // if we reach here this means that the candidate
        // is really a celebrity
        return candidate;
    }

}
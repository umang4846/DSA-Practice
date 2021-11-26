package dynamic_programming.pepcoding;

import java.util.Scanner;

public class ZeroOneKnapsackProblem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] weights = new int[n];
        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            weights[i] = scn.nextInt();
        }
        int cap = scn.nextInt();

        // System.out.println(recursiveApproach(weight, price, 0, cap));

        //   Integer[][] memo = new Integer[cap + 1][n + 1];
        //  System.out.println(recursiveMemoizationApproach(weights, price, 0, cap, memo));

        System.out.println(dpApproach(weights, price, 0, cap));
    }

    static int recursiveApproach(int[] weights, int[] price, int index, int cap) {
        if (index == weights.length || cap == 0) {
            return 0;
        }

        if (weights[index] > cap) {
            return recursiveApproach(weights, price, index + 1, cap);
        }

        int choice1 = recursiveApproach(weights, price, index + 1, cap - weights[index]) + price[index];
        int choice2 = recursiveApproach(weights, price, index + 1, cap);

        return Math.max(choice1, choice2);
    }

    static int recursiveMemoizationApproach(int[] weights, int[] price, int index, int cap, Integer[][] memo) {
        if (index == weights.length || cap == 0) {
            return 0;
        }

        if (memo[cap][index] != null) {
            return memo[cap][index];
        }

        if (weights[index] > cap) {
            return recursiveMemoizationApproach(weights, price, index + 1, cap, memo);
        }

        int choice1 = recursiveMemoizationApproach(weights, price, index + 1, cap - weights[index], memo) + price[index];
        int choice2 = recursiveMemoizationApproach(weights, price, index + 1, cap, memo);

        int max = Math.max(choice1, choice2);
        memo[cap][index] = max;
        return max;
    }

    static int dpApproach(int[] weights, int[] price, int index, int cap) {
        int[][] dp = new int[weights.length + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int value = price[i - 1];
                int weight = weights[i - 1];
                if (weight <= j) {
                    int remainingWeight = j - weight;
                    int choice1 = dp[i - 1][remainingWeight] + value;
                    int choice2 = dp[i - 1][j];
                    dp[i][j] = Math.max(choice1, choice2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[weights.length][cap];
    }

}

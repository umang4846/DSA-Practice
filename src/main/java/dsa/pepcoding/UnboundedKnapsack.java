package dsa.pepcoding;

import java.util.Scanner;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int cap = scanner.nextInt();
        int[] dp = new int[cap + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= weights[j]) {
                    int weight = weights[j];
                    int remainingCap = i - weight;
                    dp[i] = Math.max(dp[remainingCap] + values[j], dp[i]);
                }
            }
        }

        System.out.println(dp[cap]);

    }

}

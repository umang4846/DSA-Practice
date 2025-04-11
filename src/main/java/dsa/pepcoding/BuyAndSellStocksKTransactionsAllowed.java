package dsa.pepcoding;

import java.util.Scanner;

public class BuyAndSellStocksKTransactionsAllowed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        usedMoreTC(n, arr, k);

        optimizedTC(n, arr, k);
    }

    static void usedMoreTC(int n, int[] arr, int k) {
        int[][] dp = new int[k + 1][n];
        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < n; d++) {
                int max = dp[t][d - 1];
                for (int pd = 0; pd < d; pd++) {
                    int ptilltm1 = dp[t - 1][pd];
                    int ptilltth = arr[d] - arr[pd];
                    if (ptilltm1 + ptilltth > max) {
                        max = ptilltm1 + ptilltth;
                    }
                }
                dp[t][d] = max;
            }
        }
        System.out.println(dp[k][n - 1]);
    }

    static void optimizedTC(int n, int[] arr, int k) {
        int[][] dp = new int[k + 1][n];
        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < arr.length; d++) {
                if (dp[t - 1][d - 1] - arr[d - 1] > max) {
                    max = dp[t - 1][d - 1] - arr[d - 1];
                }

                if (max + arr[d] > dp[t][d - 1]) {
                    dp[t][d] = max + arr[d];
                } else {
                    dp[t][d] = dp[t][d - 1];
                }
            }
        }
        System.out.println(dp[k][n - 1]);
    }
}

package dsa.pepcoding;

import java.util.Scanner;

public class MincostInMazeTraversal {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                } else if (j == m - 1) {
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                } else {
                    int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                    dp[i][j] = arr[i][j] + min;
                }
            }
        }
        System.out.println(dp[0][0]);
    }

}

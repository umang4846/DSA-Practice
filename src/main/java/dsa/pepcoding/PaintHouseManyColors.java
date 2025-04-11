package dsa.pepcoding;

import java.util.Scanner;

public class PaintHouseManyColors {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] arr = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        usedMoreTC(n, k, arr);  //N * K * K

        improvedTC(n, k, arr);  //N * K

    }

    private static void improvedTC(int n, int k, int[][] arr) {

        int least = Integer.MAX_VALUE;
        int secondLeast = Integer.MAX_VALUE;

        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = arr[0][i];
            if (arr[0][i] < least) {
                secondLeast = least;
                least = arr[0][i];
            } else if (arr[0][i] < secondLeast) {
                secondLeast = arr[0][i];
            }
        }

        for (int i = 1; i < n; i++) {
            int newLeast = Integer.MAX_VALUE;
            int newSecondLeast = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (dp[i - 1][j] == least) {
                    dp[i][j] = arr[i][j] + secondLeast;
                } else {
                    dp[i][j] = arr[i][j] + least;
                }
                if (dp[i][j] < newLeast) {
                    newSecondLeast = newLeast;
                    newLeast = dp[i][j];
                } else if (dp[i][j] < newSecondLeast) {
                    newSecondLeast = dp[i][j];
                }
            }
            least = newLeast;
            secondLeast = newSecondLeast;
        }

        System.out.println(least);
    }

    private static void usedMoreTC(int n, int k, int[][] arr) {


        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = arr[0][i];
        }
        //or         System.arraycopy(arr[0], 0, dp[0], 0, k);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (j != l) {
                        if (dp[i - 1][l] < min) {
                            min = dp[i - 1][l];
                        }
                    }
                }
                dp[i][j] = arr[i][j] + min;
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (dp[n - 1][i] < minCost) {
                minCost = dp[n - 1][i];
            }
        }
        System.out.println(minCost);
    }


}

package dsa.pepcoding;

import java.util.Scanner;

public class TilingWith2X1Tiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        usedMoreSC(n);
        optimizedSC(n);
    }

    private static void optimizedSC(int n) {
        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int temp = first;
            first = second;
            second = temp + second;
            // dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(second);
    }

    private static void usedMoreSC(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1; // 2 X 1 floor (only can arrange horizontally)
        dp[2] = 2; // 2 X 2 floor (can arrange in 2 tiles horizontally and 2 tiles vertically so total 2 ways)

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);

    }


}

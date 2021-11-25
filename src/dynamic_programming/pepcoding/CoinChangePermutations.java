package dynamic_programming.pepcoding;

import java.util.Scanner;

public class CoinChangePermutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = scanner.nextInt();
        }
        int amount = scanner.nextInt();

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }

        System.out.println(dp[amount]);
    }
}

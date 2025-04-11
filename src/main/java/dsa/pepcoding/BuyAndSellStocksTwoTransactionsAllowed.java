package dsa.pepcoding;

import java.util.Scanner;

public class BuyAndSellStocksTwoTransactionsAllowed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int maxProfitIfSoldToday = 0;
        int leastSoFar = arr[0];
        int[] dpLeft = new int[n];

        for (int i = 1; i < n; i++) {
            if (arr[i] < leastSoFar) {
                leastSoFar = arr[i];
            }
            maxProfitIfSoldToday = arr[i] - leastSoFar;
            if (maxProfitIfSoldToday > dpLeft[i - 1]) {
                dpLeft[i] = maxProfitIfSoldToday;
            } else {
                dpLeft[i] = dpLeft[i - 1];
            }
        }

        int maxProfitIfBoughtToday = 0;
        int maxSoFar = arr[n - 1];
        int[] dpRight = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxSoFar) {
                maxSoFar = arr[i];
            }
            maxProfitIfBoughtToday = maxSoFar - arr[i];
            if (maxProfitIfBoughtToday > dpRight[i + 1]) {
                dpRight[i] = maxProfitIfBoughtToday;
            } else {
                dpRight[i] = dpRight[i + 1];
            }
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dpLeft[i] + dpRight[i] > maxProfit) {
                maxProfit = dpLeft[i] + dpRight[i];
            }
        }
        System.out.println(maxProfit);
    }
}
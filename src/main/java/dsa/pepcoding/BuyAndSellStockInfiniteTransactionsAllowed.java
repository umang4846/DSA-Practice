package dsa.pepcoding;

import java.util.Scanner;

public class BuyAndSellStockInfiniteTransactionsAllowed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int sellingDayIndex = 0;
        int buyingDayIndex = 0;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                sellingDayIndex++;
            } else {
                profit += arr[sellingDayIndex] - arr[buyingDayIndex];
                sellingDayIndex = i;
                buyingDayIndex = i;
            }
        }
        profit += arr[sellingDayIndex] - arr[buyingDayIndex];
        System.out.println(profit);
    }
}

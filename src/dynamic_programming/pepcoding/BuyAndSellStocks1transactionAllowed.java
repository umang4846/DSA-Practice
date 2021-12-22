package dynamic_programming.pepcoding;

import java.util.Scanner;

public class BuyAndSellStocks1transactionAllowed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int leastSoFar = Integer.MAX_VALUE;
        int overAllProfit = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < leastSoFar) {
                leastSoFar = arr[i];
            }
           int currentProfit = arr[i] - leastSoFar;
            if (overAllProfit < currentProfit) {
                overAllProfit = currentProfit;
            }
        }
        System.out.println(overAllProfit);
    }
}

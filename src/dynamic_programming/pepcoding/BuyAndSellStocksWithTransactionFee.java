package dynamic_programming.pepcoding;

import java.util.Scanner;

public class BuyAndSellStocksWithTransactionFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int fee = scanner.nextInt();
        int oldBoughtStateProfit = -arr[0];
        int oldSoldStateProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            int newBoughtStateProfit = 0;
            int newSoldStateProfit = 0;
            if(oldSoldStateProfit - arr[i] > oldBoughtStateProfit){
                newBoughtStateProfit = oldSoldStateProfit - arr[i];
            }else{
                newBoughtStateProfit = oldBoughtStateProfit;
            }

            if(oldBoughtStateProfit + arr[i] - fee > oldSoldStateProfit){
                newSoldStateProfit = oldBoughtStateProfit + arr[i] - fee;
            }else{
                newSoldStateProfit = oldSoldStateProfit;
            }
            oldBoughtStateProfit = newBoughtStateProfit;
            oldSoldStateProfit = newSoldStateProfit;
        }
        System.out.println(oldSoldStateProfit);
    }
}

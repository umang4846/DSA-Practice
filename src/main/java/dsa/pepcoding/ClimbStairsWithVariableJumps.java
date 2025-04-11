package dsa.pepcoding;

import java.util.Scanner;

public class ClimbStairsWithVariableJumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i =0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

    //    int count = countStepsRecursion(arr, 0, n);
     //   System.out.println(count);

        int[] dp = new int[n+1];
        dp[n] = 1;

        for (int i = n-1; i>=0; i--){
            for (int j = 1; j<= arr[i] && i + j <= n; j++){
                dp[i] = dp[i] + dp[i+j];
            }
        }

        System.out.println(dp[0]);

    }

    static int countStepsRecursion(int[] arr, int index, int n){
        if (index == n){
            return 1;
        }
        int count = 0;
        for (int i = 1; i<= arr[index]; i++){
            if (i + index <= n) {
                count += countStepsRecursion(arr, index + i, n);
            }else{
                break;
            }
        }
        return count;
    }

}




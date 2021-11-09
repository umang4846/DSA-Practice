package dynamic_programming.pepcoding;

import java.util.Scanner;
/*
* TC : O(N)
* SC : O(N+N) ~ O(N)
* */
public class Fibonacci {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(finMemo(n, new int[n + 1]));

    }

    public static int finMemo(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }

        int ans = finMemo(n - 1, qb) + finMemo(n - 2, qb);
        qb[n] = ans;
        return ans;
    }
}

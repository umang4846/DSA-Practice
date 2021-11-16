package dynamic_programming.pepcoding;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.println(climbStairsRec(n));
//        System.out.println(climbStairsMemo(n, new int[n + 1]));
        System.out.println(climbStairsTabulation(n));
    }

    //Recursive not so optimized
    private static int climbStairsRec(int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int ns1 = climbStairsRec(n - 1);
        int ns2 = climbStairsRec(n - 2);
        int ns3 = climbStairsRec(n - 3);

        return ns1 + ns2 + ns3;
    }

    //Recursion with Memoization optimized compare to normal recursion
    private static int climbStairsMemo(int n, int[] qb) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (qb[n] != 0) {
            return qb[n];
        }

        int ns1 = climbStairsMemo(n - 1, qb);
        int ns2 = climbStairsMemo(n - 2, qb);
        int ns3 = climbStairsMemo(n - 3, qb);

        int ans = ns1 + ns2 + ns3;
        qb[n] = ans;
        return ans;

    }

    private static int climbStairsTabulation(int n) {
        int[] tabulation = new int[n + 1];
        tabulation[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                tabulation[i] = tabulation[i - 1];
            } else if (i == 2) {
                tabulation[i] = tabulation[i - 1] + tabulation[i - 2];
            } else {
                tabulation[i] = tabulation[i - 1] + tabulation[i - 2] + tabulation[i - 3];
            }
        }
        return tabulation[n];

    }

}

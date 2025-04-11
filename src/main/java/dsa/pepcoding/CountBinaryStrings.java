package dsa.pepcoding;

import java.util.Scanner;

public class CountBinaryStrings {

    public static void main(String[] args) throws Exception {
        usedMoreSpace();

        improvedCode();
    }

    public static void improvedCode() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int zeroes = 1;
        int ones = 1;
        for (int i = 2; i <= n; i++) {
            int nzeroes = ones;
            int nones = ones + zeroes;

            zeroes = nzeroes;
            ones = nones;
        }

        System.out.println(zeroes + ones);
    }

    public static void usedMoreSpace() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];
        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp0[i] = dp1[i - 1];
            dp1[i] = dp0[i - 1] + dp1[i - 1];
        }

        System.out.println(dp0[n] + dp1[n]);
    }

}

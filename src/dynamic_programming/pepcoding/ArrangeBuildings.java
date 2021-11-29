package dynamic_programming.pepcoding;

import java.util.Scanner;

public class ArrangeBuildings {

    public static void main(String[] args) throws Exception {

        usedMoreSpace();

        improvedCode();
    }

    public static void usedMoreSpace() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        long[] dpBuilding = new long[n + 1];
        long[] dpSpace = new long[n + 1];
        dpBuilding[1] = 1;
        dpSpace[1] = 1;

        for (int i = 2; i <= n; i++) {
            dpBuilding[i] = dpSpace[i - 1];
            dpSpace[i] = dpBuilding[i - 1] + dpSpace[i - 1];
        }
        long total = dpBuilding[n] + dpSpace[n];
        System.out.println(total * total);
    }

    public static void improvedCode() {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();

        long ob = 1;
        long os = 1;
        for (int i = 2; i <= n; i++) {
            long nb = os;
            long ns = os + ob;

            ob = nb;
            os = ns;
        }
        long total = ob + os;
        System.out.println(total * total);
    }

}

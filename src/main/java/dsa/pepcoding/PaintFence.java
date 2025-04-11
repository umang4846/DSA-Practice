package dsa.pepcoding;

import java.util.Scanner;

public class PaintFence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long same = k * 1;
        long diff = k * (k - 1);
        long total = same + diff;

        for (int i = 3; i <= n; i++) {
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }
        System.out.println(total);
    }
}

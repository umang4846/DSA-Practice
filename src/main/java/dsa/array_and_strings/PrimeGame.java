package dsa.array_and_strings;

import java.util.Scanner;

public class PrimeGame {
    public static void main(String args[]) throws Exception {

        //Write code here
        Scanner sc = new Scanner(System.in);
        int noOfTestCase = Integer.parseInt(sc.nextLine());
        String[] testCase = new String[noOfTestCase];
        for (int i = 0; i < noOfTestCase; i++) {
            String range1 = sc.next();
            String range2 = sc.next();
            testCase[i] = range1 + "," + range2;
        }
        for (String range : testCase) {
            String stringArr[] = range.split(",");
            System.out.println(maxDifference(Integer.parseInt(stringArr[0]), Integer.parseInt(stringArr[1])));
        }

    }

    static int maxDifference(int a, int b) {
        int x = 0, y = 0;
        boolean isPrimePossible = false;
        if (a % 2 == 0 && a != 2)
            a = a + 1;
        if (b % 2 == 0 && b != 2)
            b = b - 1;
        for (int i = a; i <= b; i += 2) {
            if (isprime(i) == true) {
                isPrimePossible = true;
                x = i;
                break;
            }
        }
        for (int i = b; i >= a; i -= 2) {
            if (isprime(i) == true) {
                isPrimePossible = true;
                y = i;
                break;
            }
        }
        if(isPrimePossible){
            return y - x;
        }else{
            return -1;
        }
        
    }

    public static boolean isprime(int a) {
        if (a <= 1)
            return false;
        if (a <= 3)
            return true;
        if (a % 2 == 0 || a % 3 == 0)
            return false;
        for (int i = 5; i * i <= a; i += 6) {
            if (a % i == 0 || a % (i + 2) == 0)
                return false;
        }
        return true;
    }

}
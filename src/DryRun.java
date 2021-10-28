import sun.text.normalizer.Trie;

import java.util.*;

public class DryRun {
    public static void main(String[] args) {
      /*  String s = "the sky is blue";
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        System.out.println(String.join(" ", words));*/
        //printBothWay(5);
       // digitSum1(500);
        //System.out.println(sum);
      //  System.out.println(countZeros(1111,0));
        printTriangle(4,0);
    }


    public static void printBothWay(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printBothWay(n-1);
        System.out.println(n);
    }


    static int sum = 0;
    static void digitSum1(int n){
        if(n == 0){
            return;
        }
        int remainder = n % 10;
        sum = sum * 10 + remainder;
        digitSum1(n/10);
    }

    static int countZeros(int n, int c){
        if(n == 0){
            return c;
        }
        int rem = n % 10;
        if(rem == 0){
            return countZeros(n/10, ++c);
        }
        return countZeros(n/10, c);
    }

    public static void printTriangle(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            System.out.print("*");
            printTriangle(row, col+1);
        }else{
            System.out.println();
            printTriangle(row-1, 0);
        }
    }

}

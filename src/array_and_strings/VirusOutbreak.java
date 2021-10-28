package array_and_strings;


import java.io.*;
import java.util.*;
public class VirusOutbreak {
    public static void main(String args[] ) throws Exception {

        //Write code here
        Scanner sc = new Scanner(System.in);
        String v = sc.nextLine();
        int noOfPatients = Integer.parseInt(sc.nextLine());
        String[] compositions = new String[noOfPatients];
        for(int i=0; i<noOfPatients;i++){
            compositions[i] = sc.nextLine();
        }
        for(String s : compositions){
            System.out.println(isSubSequence(v,s) == true ? "POSITIVE" : "NEGATIVE");
        }


    }

    public static boolean isSubSequence(String big, String small){
        if(big.equalsIgnoreCase(small)){
            return true;
        }
        int n = big.length();
        int j = 0;
        for(int i = 0; i < n; i++){
            if(small.charAt(j) == big.charAt(i))
                j++;
            if(j == small.length())
                return true;
        }
        return false;

    }
}
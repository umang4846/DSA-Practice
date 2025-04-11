package dsa.kunal_kushwaha_dsa.recursion;

/*
 *       1      2      3
 *      abc   def     ghi
 *      012  345     678
 *
 *       4      5      6
 *      jkl   mno     pqr
 *      91011 121314 151617
 *
 *       7      8      9
 *      stu   vwx     yz
 *     181920 212223  2425
 * */

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public static void main(String[] args) {
      //  pad("","12");
      //  System.out.println(padReturnList("","89"));
        System.out.println(padCount("","89"));
    }

    static void pad(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        int digit = unprocessed.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3 && i<26; i++){
            char ch = (char) ('a' + i);
            pad(processed + ch, unprocessed.substring(1));
        }
    }

    static List<String> padReturnList(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        int digit = unprocessed.charAt(0) - '0';
        List<String> ans = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3 && i<26; i++){
            char ch = (char) ('a' + i);
            List<String> list = padReturnList(processed + ch, unprocessed.substring(1));
            ans.addAll(list);
        }
        return ans;
    }

    static int padCount(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            return 1;
        }
        int count = 0;
        int digit = unprocessed.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3 && i<26; i++){
            char ch = (char) ('a' + i);
            count = count + padCount(processed + ch, unprocessed.substring(1));
        }
        return count;
    }
}


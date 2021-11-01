package kunal_kushwaha_dsa.recursion;

import java.util.ArrayList;
import java.util.List;

/*
* Note :
* -> in Arrays, it will be subsets
* -> in strings, it will be subsequences
* in subsets/subsequences either we will include character or not
*
* */
public class Subsequence {

    public static void main(String[] args) {
       // subsequences("", "abc");
        // System.out.println(subsequenceWithReturn("", "abc"));
       // subsequencesAscii("","abc");
        System.out.println(subsequencesAsciiWithReturn("","abc"));
    }

    public static void subsequences(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);
        subsequences(processed + ch, unprocessed.substring(1));
        subsequences(processed, unprocessed.substring(1));
    }

    public static List<String> subsequenceWithReturn(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        List<String> left = subsequenceWithReturn(processed + ch, unprocessed.substring(1));
        List<String> right = subsequenceWithReturn(processed,unprocessed.substring(1));

        left.addAll(right);
        return left;
    }

    /*
    * Subsequences with ASCII code of character
    * */
    public static void subsequencesAscii(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);
        subsequencesAscii(processed + ch, unprocessed.substring(1));
        subsequencesAscii(processed, unprocessed.substring(1));
        subsequencesAscii(processed + (ch+0), unprocessed.substring(1));
    }

    public static List<String> subsequencesAsciiWithReturn(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        List<String> first = subsequencesAsciiWithReturn(processed + ch, unprocessed.substring(1));
        List<String> second = subsequencesAsciiWithReturn(processed,unprocessed.substring(1));
        List<String> third = subsequencesAsciiWithReturn(processed+ (ch+0),unprocessed.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first;
    }

}

package recursion;

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
        System.out.println(subsequenceWithReturn("", "abc"));
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
}

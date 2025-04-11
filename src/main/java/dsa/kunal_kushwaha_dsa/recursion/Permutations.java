package dsa.kunal_kushwaha_dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        //permutations("", "abc");
       // System.out.println(permutationsList("", "abc"));
        System.out.println(permutationsCount("","abcde"));
    }

    static void permutations(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            permutations(first + ch + second, unprocessed.substring(1));
        }
    }

    public static List<String> permutationsList(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> ans = new ArrayList<>();
        char ch = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            ans.addAll(permutationsList(first + ch + second, unprocessed.substring(1)));
        }
        return ans;
    }

     static int permutationsCount(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            return 1;
        }
        int count = 0;
        char ch = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            count = count + permutationsCount(first + ch + second, unprocessed.substring(1));
        }
        return count;
    }
}

package dsa.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

    public static boolean isPalindrome(String str){
        int i =0;
        int j = str.length() - 1;
        while(i <= j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if(words.length < 2){
            return ans;
        }
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<words.length; i++){
            map.put(reverse(words[i]), i);
        }
        for(int i = 0; i < words.length; i++){
            for(int j =0; j<=words[i].length(); j++){
                String prefix = words[i].substring(0,j);
                String suffix = words[i].substring(j);
                /* WARNING: MUST CHECK whether str.length() is equal to 0 in either if statement, because we need to make sure
                 *  we do not add duplicate pairs (if prefix.length() == 0, both of prefix and suffix will from input array) */
                if(!prefix.isEmpty() && isPalindrome(prefix) && map.containsKey(suffix) && map.get(suffix) != i){
                    List<Integer> list = new ArrayList<>();
                    list.add(map.get(suffix));
                    list.add(i);
                    ans.add(list);
                }
                if(isPalindrome(suffix) && map.containsKey(prefix) && map.get(prefix) != i){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(map.get(prefix));
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<List<Integer>> palindromePairs = palindromePairs(new String[]{"abcdc","ba"});
        for(List<Integer> list : palindromePairs){
            for(Integer index : list){
                System.out.print(index + " ");
            }
            System.out.println();
        }
    }

}

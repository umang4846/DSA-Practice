package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backTrack(ans, 0, map, new StringBuilder(), digits);
        return ans;
    }

    public void backTrack(List<String> ans, int index, Map<Character, String> map, StringBuilder sb, String digits) {
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String curr = map.get(digits.charAt(index));
        for(int i = 0; i<curr.length(); i++){
            sb.append(curr.charAt(i));
            backTrack(ans, index + 1, map, sb, digits);
            sb.deleteCharAt(sb.length() - 1); //Remember Syntax
        }
    }
}

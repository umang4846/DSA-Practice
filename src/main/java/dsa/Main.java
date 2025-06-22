package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(anagrams(new String[]{"cat", "tac", "act", "on", "no", "abcd", "cabd"}));
    }

    private static List<List<String>> anagrams(String[] input) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : input) {
            char[] charArray = new char[26];
            for (char c : str.toCharArray()) {
                charArray[c-'a']++;
            }
            String key = new String(charArray);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

}

package dsa.array_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Encode and Decode Strings
* Link: https://leetcode.com/problems/encode-and-decode-strings/description/
*/
public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        List<String> test = List.of("abc","123","122323","xyz");
        String s = encodeAndDecodeStrings.encode(test);
        List<String> ans = encodeAndDecodeStrings.decode(s);

        assert test.equals(ans);

    }
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while(i < str.length()){
            //get the inex of #
            int index = i;
            while(str.charAt(index) != '#'){
                index++;
            }

            int len = Integer.valueOf(str.substring(i, index));
            i = index + 1 + len;
            res.add(str.substring(index + 1, i));
        }
        return res;
    }
}
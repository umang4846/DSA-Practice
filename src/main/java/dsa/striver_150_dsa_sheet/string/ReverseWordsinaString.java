package dsa.striver_150_dsa_sheet.string;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsinaString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {

        int i = s.length() - 1;
        StringBuilder result = new StringBuilder();

        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int j = i;

            if (i < 0) {
                break;
            }

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            if (result.toString().isEmpty()) {
                result.append(s, i + 1, j + 1);
            } else {
                result.append(" ").append(s, i + 1, j + 1);
            }

        }
        return result.toString();

    }

    //Appproach  2 Java Built In
    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

}

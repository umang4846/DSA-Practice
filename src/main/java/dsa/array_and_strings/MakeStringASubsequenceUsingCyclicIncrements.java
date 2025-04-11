package dsa.array_and_strings;

/*
 * Name : 2825. Make String a Subsequence Using Cyclic Increments
 * Link : https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description
 * */
public class MakeStringASubsequenceUsingCyclicIncrements {
    public static void main(String[] args) {
        MakeStringASubsequenceUsingCyclicIncrements obj = new
                MakeStringASubsequenceUsingCyclicIncrements();
        System.out.println("-------" + obj.canMakeSubsequence("abc", "ad") + "------");
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        int str2Index = 0;
        int lengthStr1 = str1.length();
        int lengthStr2 = str2.length();

        for (int str1Index = 0; str1Index < lengthStr1 && str2Index < lengthStr2; ++str1Index) {

            if (str1.charAt(str1Index) == str2.charAt(str2Index) ||
                    (str1.charAt(str1Index) + 1 == str2.charAt(str2Index)) ||
                    (str1.charAt(str1Index) - 25 == str2.charAt(str2Index))) {
                str2Index++;
            }
        }
        return str2Index == lengthStr2;
    }

}

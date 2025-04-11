package dsa.array_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> list = generate1(n);

        for (List<Integer> integerList : list) {
            for (Integer integer : integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }*/
/*
        //============== Add Binary =============
        System.out.println(addBinary("1010", "1011"));*/

      /*  //============== strStr() ===============
        System.out.println(strStr("hello", "ll"));*/

   /*     //=============Longest Common Prefix ==============
        String[] strs = new String[]{"flowers", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));*/

      /*  //================  Array Partition I ===============
        System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));*/

        //===================Two Sum II - Input array is sorted ===================
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0)
                sum += a.charAt(i) - '0';
            if (j >= 0)
                sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;


        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();

    }

    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> integerList = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {

                if (j == 0 || i == j) {
                    integerList.add(1);
                } else {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    integerList.add(a + b);
                }
            }
            result.add(integerList);
        }
        return result;
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int j = 0;
        for (int i = 0; i <= m - n; i++) {
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == n - 1) {
                    return i;
                }
            }
        }
        return -1;

    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }

        }
        return prefix;


    }

    public static int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        System.gc();
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += nums[i];
        }
        return sum;

    }

    public static int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int l = numbers[left];
            int r = numbers[right];
            if (l + r == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (l + r < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
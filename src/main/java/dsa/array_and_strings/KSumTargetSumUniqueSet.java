package dsa.array_and_strings;

import java.util.*;

public class KSumTargetSumUniqueSet {
    public static List<List<Integer>> twoSum(int[] arr, int target, int si) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n - si < 2) {
            return ans;
        }
        int left = si;
        int right = n - 1;
        while (left < right) {
            if (left != si && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            int curr = arr[left] + arr[right];
            if (curr == target) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[left]);
                list.add(arr[right]);
                ans.add(list);
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (curr < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static List<List<Integer>> kSum(int[] arr, int target, int k) {
        Arrays.sort(arr);
        return kSumHelper(arr, target, k, 0);
    }

    public static List<List<Integer>> kSumHelper(int[] arr, int target, int k, int si) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        if (k == 2) {
            return twoSum(arr, target, si);
        }
        if (n - si < k) {
            return res;
        }
        for (int i = si; i <= n - k; i++) {
            if (i != si && arr[i] == arr[i - 1]) {
                continue;
            }
            List<List<Integer>> smallList = kSumHelper(arr, target - arr[i], k - 1, i + 1);
            for (List<Integer> list : smallList) {
                list.add(arr[i]);
                res.add(list);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        int k = scn.nextInt();
        List<List<Integer>> res = kSum(arr, target, k);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
                ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }

}

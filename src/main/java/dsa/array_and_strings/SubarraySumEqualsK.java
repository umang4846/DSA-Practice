package dsa.array_and_strings;

import java.util.HashMap;

/*
 * 560. Subarray Sum Equals K
 *
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 * */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,7,-2,2,1,4,2};
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        obj.subarraySum(arr, 7);
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}

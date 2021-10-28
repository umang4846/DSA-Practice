package stack;

public class TargetSum {
    // https://leetcode.com/problems/target-sum/
    // https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
    // So the original problem has been converted to a subset sum problem as follows:
    // Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
    // https://leetcode.com/problems/coin-change-2/ is NOT the same problem
    // For coin-change-2: a set of numbers, all positive, no duplicates, same number can be used multiple times; for results, order doesn't matter.
    // For this problem:  a set of numbers, all positive, yes duplicates, same number can be used only once; for results, order doesn't matter.
    // This is similar to: https://leetcode.com/problems/combination-sum-ii/, which is asking for all the combinations,
    // while this problem is asking for the number of unique combos.
    // review6
    // a set of numbers, all positive, might be duplicates, same number can be used only once
    // Number of combinations that add up to the target, order doesn't matter (1,1,2) and (1,2,1) are the same
    public int findTargetSumWays(int[] nums, int S) {

        if (nums == null || nums.length <= 0)
            return 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        int total = S + sum;
        if (total % 2 > 0 || sum < S)
            return 0;

        return subsetSum(nums, total / 2);
    }

    public int subsetSum(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums)
            for (int i = target; i >= num; i--)
                // NOTE the order: from target DOWN to num, not the other way (like other problems)
                dp[i] += dp[i - num];

        return dp[target];
    }
}


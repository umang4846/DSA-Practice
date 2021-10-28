package array_and_strings;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                result = Math.min(result, i + 1 - left);
                sum = sum - nums[left];
                left++;
            }
        }
        return result != Integer.MAX_VALUE ? result : 0;


    }

}

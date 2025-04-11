package dsa.array_and_strings;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        ;
        while (left < right) {
            if (left != 0 && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            int curr = nums[left] + nums[right];
            if (curr == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                ans.add(list);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
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

    // ~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
    }

}

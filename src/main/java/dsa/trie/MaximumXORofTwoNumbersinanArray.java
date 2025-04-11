package dsa.trie;

import java.util.Arrays;
import java.util.Collections;

public class MaximumXORofTwoNumbersinanArray {
    //Approach 1 TC : O(N^2)
    public int findMaximumXOR1(int[] nums) {
        int max = 0;
        for(int i =0;i<nums.length;i++){
            for(int j = i+1; j<nums.length; j++){
                max = Math.max(max, nums[i]^nums[j]);
            }
        }
        return max;
    }
    //Approach 2
    public int findMaximumXOR(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for(int i =0; i<nums.length;i++){
            arr[i] = nums[i];
        }

        Arrays.sort(arr,  Collections.reverseOrder());
        int max = Integer.MIN_VALUE;
        for(int i =0; i<arr.length-1;i++){
            int xor = arr[i] ^ arr[i+1];
            if(max < xor){
                max = xor;
            }
        }
        return max;
    }

    public static void main(String[] args){
        MaximumXORofTwoNumbersinanArray maximumXORofTwoNumbersinanArray = new MaximumXORofTwoNumbersinanArray();
        int ans  = maximumXORofTwoNumbersinanArray.findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70});
        System.out.println(ans);
    }
}

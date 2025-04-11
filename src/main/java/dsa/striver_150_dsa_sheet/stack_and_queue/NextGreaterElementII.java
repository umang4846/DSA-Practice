package dsa.striver_150_dsa_sheet.stack_and_queue;

import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * size - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % size]) {
                st.pop();
            }
            if (i < size) {
                if (!st.isEmpty()){
                    ans[i] = st.peek();
                }
                else {
                    ans[i] = -1;
                }
            }
            st.push(nums[i % size]);
        }
        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElementII nextGreaterElementII = new NextGreaterElementII();
        nextGreaterElementII.nextGreaterElements(new int[]{1, 2, 1});
    }

}

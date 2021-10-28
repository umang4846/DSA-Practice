package striver_150_dsa_sheet.stack_and_queue;

import java.util.Stack;

public class NextSmallerElement {
    public int[] nextSmallerElements(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * size - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= nums[i % size]) {
                st.pop();
            }
            if (i < size) {
                if (!st.isEmpty()) {
                    ans[i] = st.peek();
                } else {
                    ans[i] = -1;
                }
            }
            st.push(nums[i % size]);
        }
        return ans;
    }

    public static void main(String[] args) {
        NextSmallerElement nextSmallerElement = new NextSmallerElement();
        int[] arr = nextSmallerElement.nextSmallerElements(new int[]{11, 13, 21, 3});
        for (int num : arr) {
            System.out.println(num);
        }
    }
}

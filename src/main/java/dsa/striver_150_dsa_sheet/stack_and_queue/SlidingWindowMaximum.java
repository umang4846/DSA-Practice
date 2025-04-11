package dsa.striver_150_dsa_sheet.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SlidingWindowMaximum {
    //Approach 1
    public int[] maxSlidingWindow1(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[nums.length];
        stack.push(nums.length - 1);
        //store length element into nge if no greater is there
        nge[nums.length - 1] = nums.length;
        //finding next greater for every element
        for (int i = nums.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[i] = nums.length;
            } else {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        int j = 0;
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (j < i) { //very important (not reset j every time equal to i)
                j = i;
            }
            //if nge[j] in the k window size then jump j to nge[j] index
            while (nge[j] < i + k) {
                j = nge[j];
            }
            ans[index++] = nums[j];
        }
        return ans;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] ans = swm.maxSlidingWindow1(new int[]{1, 2, 1, 5}, 2);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }

    //Approach 2 using O(N)
    public int[] maxSlidingWindow2(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}

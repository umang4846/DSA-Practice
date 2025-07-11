package dsa.striver_150_dsa_sheet.stack_and_queue;

import java.util.Stack;

public class LargestRectangleInHistogram {

    //Approach 1 : 2 pass
    // TC : O(N)
    // SC : O(N)
    public int largestRectangleArea1(int[] heights) {
        // clue is we have to include the bar completely in the maximum rectangle
        // we have to calculate for each bar, the area with width to the left and width to the right
        //  width to the left will be the smaller bar index to the left of the current bar
        // lly width to the right
        // to optimize the time to calculate width , we use dsa.stack
        // if no smaller to the left , then put 0

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        //dsa.stack to push indexes

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                // that means no element to the left, put it as 0
                left[i] = 0;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    //keep popping the elements till the smaller element is reached
                    stack.pop();
                }
                //if dsa.stack is empty no smaller element to the left
                left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
                stack.push(i);
            }
        }
        //clear the dsa.stack
        stack.clear();

        // similarly for right
        for (int i = heights.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                // that means no element to the right, put it as height.length - 1
                right[i] = heights.length - 1;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    //keep popping the elements till the smaller element is reached
                    stack.pop();
                }
                //if dsa.stack is empty no smaller element to the right then assign height.length,
                // otherwise peek of dsa.stack - 1;
                right[i] = stack.isEmpty() ? heights.length - 1 : stack.peek() - 1;
                stack.push(i);
            }
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (right[i] - left[i] + 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
    //Approach 1 : 1 pass
    // TC : O(N)
    // SC : O(N)
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        for(int i = 0;i<=n;i++) {
            while(!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.pop()];
                int width;
                if(st.isEmpty()) width = i;
                else width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram lrh = new LargestRectangleInHistogram();
        System.out.println(lrh.largestRectangleArea2(new int[]{2,1,5,6,2,3}));
    }
}

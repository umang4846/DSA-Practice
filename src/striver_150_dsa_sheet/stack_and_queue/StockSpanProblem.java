package striver_150_dsa_sheet.stack_and_queue;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    // A stack based efficient method to calculate
    // stock span values
    static int[] calculateSpan(int[] price, int n) {
        // Create a stack and push index of first element
        // to it
        Stack<Integer> st = new Stack<>();
        st.push(0);

        int[] ans = new int[n];

        // Span value of first element is always 1
        ans[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++) {

            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[i]
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            // If stack becomes empty, then price[i] is
            // greater than all elements on left of it, i.e.,
            // price[0], price[1], ..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            ans[i] = (st.empty()) ? (i + 1) : (i - st.peek());

            // Push this element to stack
            st.push(i);
        }
        return ans;
    }

    // A utility function to print elements of array
    static void printArray(int[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    // Driver method
    public static void main(String[] args) {
        int[] price = {10, 4, 5, 90, 120, 80};
        int n = price.length;

        // Fill the span values in array S[]
        int[] ans = calculateSpan(price, n);

        // print the calculated span values
        printArray(ans);
    }
}

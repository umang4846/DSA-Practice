package dsa.striver_150_dsa_sheet.stack_and_queue;

import java.util.Stack;

/*
* TC : O(N)
* SC : O(N)
* */
public class TheCelebrityProblemApproach1 {

    // Person with 2 is celebrity
    static int MATRIX[][] = {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}};

    // Returns true if a knows
    // b, false otherwise
    static boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ? true : false;
        return res;
    }

    // Returns -1 if celebrity
    // is not present. If present,
    // returns id (value from 0 to n-1).
    static int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
        int c;

        // Step 1 :Push everybody
        // onto dsa.stack
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            // Step 2 :Pop off top
            // two persons from the
            // dsa.stack, discard one
            // person based on return
            // status of knows(A, B).
            int a = st.pop();
            int b = st.pop();

            // Step 3 : Push the
            // remained person onto dsa.stack.
            if (knows(a, b)) {
                st.push(b);
            } else
                st.push(a);
        }

        c = st.pop();

        // Step 5 : Check if the last
        // person is celebrity or not
        for (int i = 0; i < n; i++) {
            // If any person doesn't
            //  know 'c' or 'a' doesn't
            // know any person, return -1
            if (i != c && (knows(c, i) ||
                    !knows(i, c)))
                return -1;
        }
        return c;
    }

    // Driver Code
    public static void main(String[] args) {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1) {
            System.out.println("No Celebrity");
        } else
            System.out.println("Celebrity ID " +
                    result);
    }
}
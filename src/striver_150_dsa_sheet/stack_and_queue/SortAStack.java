package striver_150_dsa_sheet.stack_and_queue;

import java.util.Stack;

public class SortAStack {
    //---------------------------- Iterative ------------------------------
    public Stack<Integer> sortIterative(Stack<Integer> s) {
        Stack<Integer> tempStack = new Stack<>();
        while (!s.isEmpty()) {
            int value = s.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > value) {
                s.push(tempStack.pop());
            }
            tempStack.push(value);
        }

        return tempStack;
    }

    //------------------------ Recursive ----------------------------------------

    static void sortedInsert(Stack<Integer> s, int x)
    {
        // Base case: Either stack is empty or newly
        // inserted item is greater than top (more than all existing)
        if (s.isEmpty() || x > s.peek())
        {
            s.push(x);
            return;
        }
        // If top is greater, remove the top item and recur
        int temp = s.pop();
        sortedInsert(s, x);

        // Put back the top item removed earlier
        s.push(temp);
    }
    // Method to sort stack
    static void sortStack(Stack<Integer> s)
    {
        // If stack is not empty
        if (!s.isEmpty())
        {
            // Remove the top item
            int x = s.pop();
            // Sort remaining stack
            sortStack(s);
            // Push the top item back in sorted stack
            sortedInsert(s, x);
        }
    }

}

package dsa.striver_150_dsa_sheet.stack_and_queue;

public class ImplementStackUsingArray {

    int top;
    int arr[] = new int[1000];

    ImplementStackUsingArray() {
        top = -1;
    }

    //Function to push an integer into the dsa.stack.
    void push(int a) {
        if (top == arr.length) {
            return;
        }
        top++;
        arr[top] = a;
    }

    //Function to remove an item from top of the dsa.stack.
    int pop() {
        if (top == -1) {
            return -1;
        }
        return arr[top--];
    }
}

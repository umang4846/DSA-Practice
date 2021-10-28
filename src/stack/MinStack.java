package stack;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack  = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {

        int min  = x;
        if(!minStack.isEmpty()){
            min = Math.min(minStack.peek(), min);
        }
        stack.push(x);
        minStack.push(min);

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();

    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}

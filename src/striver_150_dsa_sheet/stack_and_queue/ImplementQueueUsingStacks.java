package striver_150_dsa_sheet.stack_and_queue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> stackNewestOnTop;
    Stack<Integer> stackOldestOnTop;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stackNewestOnTop = new Stack<>();
        stackOldestOnTop = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackNewestOnTop.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shiftStack();
        return stackOldestOnTop.pop();

    }

    private void shiftStack(){
        if(stackOldestOnTop.isEmpty()){
            while(!stackNewestOnTop.isEmpty()){
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }

    /** Get the front element. */
    public int peek() {
        shiftStack();
        return stackOldestOnTop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty();
    }

}

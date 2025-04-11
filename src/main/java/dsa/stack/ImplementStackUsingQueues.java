package dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    /** Push element x onto dsa.stack. */
    public void push(int x) {
        queue.offer(x);
        int size  = queue.size();
        while(size > 1){
            queue.add(queue.remove());
            size--;
        }
    }

    /** Removes the element on top of the dsa.stack and returns that element. */
    public int pop() {
       return queue.remove();
    }

    /** Get the top element. */
    public int top() {
       return queue.peek();
    }

    /** Returns whether the dsa.stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}

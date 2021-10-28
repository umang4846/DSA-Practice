package stack;

import java.util.Stack;

class MinStack2 {

   Stack<Integer> stack;
   int min;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {

        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        //need to be after if condition not above
        stack.push(x);
    }

    public void pop() {
      int popped = stack.pop();
      if(popped == min){
          min  =  stack.pop();
      }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

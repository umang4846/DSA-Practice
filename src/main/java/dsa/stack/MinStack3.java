package dsa.stack;

public class MinStack3 {

    private Node head;

    public void push(int x) {
        if(head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args){
        MinStack3 minStack3 = new MinStack3();
        minStack3.push(-2);
        minStack3.push(0);
        minStack3.push(-3);
        System.out.println(minStack3.getMin()); // return -3
        minStack3.pop();
        System.out.println(minStack3.top());    // return 0
        System.out.println(minStack3.getMin()); // return -2
    }
}

package linkedlist;

import java.util.Stack;

public class FlattenaMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    /*
     * Approach 1
     * TC : O(N)
     * SC : O(1)
     * */
    public Node flatten1(Node head) {
        if (head == null) {
            return head;
        }
        Node current = head;
        while (current != null) {
            if (current.child == null) {
                current = current.next;
            } else {
                Node child = current.child;
                while (child.next != null) {
                    child = child.next;
                }
                child.next = current.next;
                if (current.next != null) {
                    current.next.prev = child;
                }
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }
        }
        return head;
    }

    /*
     * Approach 2
     * TC : O(N)
     * SC : O(N) */
    public Node flatten2(Node head) {
        Node curr = head;
        Node tail = head;
        Stack<Node> stack = new Stack<>();
        while(curr != null){
            if(curr.child != null){
                Node child = curr.child;
                if(curr.next != null){
                    stack.push(curr.next);
                    curr.next.prev = null;
                }
                child.prev = curr;
                curr.next = child;
                curr.child = null;
            }
            tail = curr;
            curr = curr.next;
        }
        while(!stack.isEmpty()){
            curr = stack.pop();
            tail.next = curr;
            curr.prev = tail;
            while (curr != null) {
                tail = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}

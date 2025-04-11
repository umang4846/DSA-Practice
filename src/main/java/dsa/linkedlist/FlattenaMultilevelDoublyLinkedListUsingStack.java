package dsa.linkedlist;

import java.util.Stack;

public class FlattenaMultilevelDoublyLinkedListUsingStack {


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if(head == null ){
            return head;
        }

        Node cur = head;
        Node tail = head;
        Stack<Node> stack = new Stack<>();
        while(cur != null){
            if(cur.child != null){
                Node child = cur.child;
                if(cur.next != null){
                    stack.push(cur.next);
                    cur.next.prev = null;
                }
                cur.next = child;
                child.prev = cur;
                cur.child = null;
            }
            tail = cur;
            cur = cur.next;
        }

        while(!stack.isEmpty()){
            cur = stack.pop();
            cur.prev = tail;
            tail.next = cur;
            while(cur != null){
                tail = cur;
                cur = cur.next;
            }
        }
        return head;

    }
}

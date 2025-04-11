package dsa.linkedlist;

public class CopyListwithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }
        //make copy of node
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        //Update random pointer
        cur = head;
        while (cur != null) {
            Node random = cur.random;
            if (random != null) {
                cur.next.random = random.next;
            }
            cur = cur.next.next;
        }
        //unwinding the list
        Node newHead = head.next;
        cur = head;
        while (cur != null) {
            Node copy = cur.next;
            cur.next = cur.next.next;
            if (copy.next != null) {
                copy.next = cur.next.next;
            }
            cur = cur.next;
        }
        return newHead;

    }
}

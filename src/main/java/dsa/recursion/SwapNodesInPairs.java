package dsa.recursion;

public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //recursive
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode smallHead = swapPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = smallHead;
        return newHead;

    }

    //Iterative
    public ListNode swapPairsIterative(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        while(current.next != null && current.next.next != null){
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            current.next = secondNode;
            current = current.next.next;
        }
        return temp.next;
    }
}

package dsa.linkedlist;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }
        //calculate length of LL
        ListNode cur = head;
        int length = 1;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        //assign head to last node of LL to make it circular
        cur.next = head;
        k = k % length;
        k = length - k;
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        head = cur.next;
        cur.next = null;

        return head;

    }


}

package dsa.linkedlist;

public class MergeTwoSortedLists {

    /*
     * Iterative
     * TC : O(N) where N is smaller size of list because we will iterate in while loop till smaller list became empty
     *      Then simply attaching bigger list to temp in if condition.
     * SC : O(1)
     * */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode temp = new ListNode(-1);
        ListNode head = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            //remember
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }
        return head.next;
    }
    /*
    * Recursive
    * TC : O(N+M) where N and M is length of LL. We iterating each node one by one, till one list become null
    * SC : O(N+M) Recursion call Stack
    * */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}

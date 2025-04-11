package dsa.linkedlist;

public class RemoveNthNodeFromEndofList {

    //Approach 1 Using Dummy Node TC: O(N) SC: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode tempNode = new ListNode(0);
        tempNode.next = head;

        ListNode fast = head;
        ListNode slow = tempNode;

        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tempNode.next;
    }

    //Approach 1 without Dummy Node TC: O(N) SC: O(1)
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        // we can create two pointers
        // the distrance between these two pointers is n-1
        // thus when the fast pointer reaches the end
        // the slow pointer is just before the node to be deleted

        // 1-2-3-4-5-n
        // |   |
        //     |   |

        ListNode slow=head, fast=head;
        for (int i=n; i>0; i--) {
            fast = fast.next;
        }
        // edge case, n = listsize, remove head
        if (fast == null) return head.next;
        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }


}

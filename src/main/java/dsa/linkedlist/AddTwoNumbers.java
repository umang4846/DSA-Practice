package dsa.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;

        while(l1 !=null || l2 != null || carry!=0){
            int sum = 0;
            if(l1!=null){
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum%10);
            temp.next = newNode;
            temp = temp.next;
        }
        return dummy.next;

    }
}

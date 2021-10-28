package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    //Approach 2 TC : O(N) SC: O(1)
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow.next;
        ListNode next = null;
        ListNode prev = null;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur =next;
        }

        slow.next = prev;
        slow = slow.next;

        while(slow != null){
            if(head.val != slow.val){
                return false;
            }else{
                head = head.next;
                slow = slow.next;
            }
        }
        return true;
    }

    //Approach 1 TC : O(N) SC: O(N)
    public boolean isPalindrome1(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size()-1;
        while(start < end){
            if(list.get(start).intValue() != list.get(end).intValue()){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}

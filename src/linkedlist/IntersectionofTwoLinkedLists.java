package linkedlist;

public class IntersectionofTwoLinkedLists {
    //Approach 1 (Easy to understand) TC : O(N + M) SC : O(1)
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }

    //Approach 2 (Little complex but intutive) TC : O(N + M) SC : O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //get the length of List A
        int lengthA = 0;
        ListNode tempA = headA;
        while(tempA != null){
            lengthA++;
            tempA = tempA.next;
        }
        //get the length of List B
        int lengthB  = 0;
        ListNode tempB = headB;
        while(tempB != null){
            lengthB++;
            tempB = tempB.next;
        }
        //get the difference of two list
        int diff = Math.abs(lengthA - lengthB);
        //re-initialize temp variables to heads of list
        tempA = headA;
        tempB = headB;
        //set longer list to diff steps ahead
        if(lengthA > lengthB){
            while(diff > 0){
                tempA = tempA.next;
                diff--;
            }
        }else{
            while(diff > 0){
                tempB = tempB.next;
                diff--;
            }
        }
        //now start iterating both temp variables to check intersection node
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
            if(tempA == null || tempB == null){
                return tempA;
            }
        }
        return tempA;

    }

}

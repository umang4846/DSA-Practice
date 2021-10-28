package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointerUsingHashMap {

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

        //Using hashmap
        if(head == null){
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        for(Node key : map.keySet()){
            Node newNode = map.get(key);
            newNode.next = map.get(key.next);
            newNode.random = map.get(key.random);
        }
        return map.get(head);

    }

}

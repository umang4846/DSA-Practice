package striver_150_dsa_sheet.stack_and_queue;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node data = map.get(key);
            //move data to the top
            //remove the node
            remove(data);
            //insert it
            insert(data);
            return data.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //if value is already present we move it to top
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        //if cache is full
        if (capacity == map.size()) {
            remove(tail.prev);
        }
        //tail.prev --> least recently used
        insert(new Node(key, value));
    }

    void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node) {
        //insert into map
        map.put(node.key, node);
        //point node's next to head's next
        node.next = head.next;
        //point head's next' prev to node
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

package dsa.binary_trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connectIterative(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur == null && queue.isEmpty()) {
                return root;
            }else if(cur == null){
                queue.add(null);
                continue;
            }else{
                cur.next = queue.peek();
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }

        //Recursive
    public Node connectRecursive(Node root) {
        if(root == null || root.left == null || root.right == null){
            return root;
        }
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connectRecursive(root.left);
        connectRecursive(root.right);
        return root;
    }

    

}

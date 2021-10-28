package binary_trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {



    //--------------- TC : O(N) & SC : O(N) --------------------------
    public Node connectApproach1(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node dummy = new Node(0);
            while(size > 0){
                Node node = queue.poll();
                dummy.next = node;
                dummy = dummy.next;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                size--;
            }
        }
        return root;
    }

    //----------------------- TC : O(N) & SC : O(1) -----------------------
    public static Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node head = root;
        while(head != null){
            Node dummy = new Node(0);
            Node temp = dummy;
            while(head != null){
                if(head.left != null){
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right != null){
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }

    public static void main(String[] args) {
        Node treeNode1 = new Node(1);
        Node treeNode2 = new Node(2);
        Node treeNode3 = new Node(3);;
        Node treeNode4 = new Node(4);
        Node treeNode5 = new Node(5);
        Node treeNode6 = new Node(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.right = treeNode6;

        Node node = connect(treeNode1);

    }


}

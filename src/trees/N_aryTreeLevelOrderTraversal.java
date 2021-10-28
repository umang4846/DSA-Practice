package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_aryTreeLevelOrderTraversal {

    //Iterative
    public List<List<Integer>> levelOrderIterative(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            result.add(level);
        }
        return result;
    }

    //------------ Recursive ------------------
    public static List<List<Integer>> levelOrderRecursive(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public static void helper(Node node, List<List<Integer>> result, int level) {
        if(node==null) {
            return;
        }

        if(result.size()==level) {
            result.add(new ArrayList());
        }

        result.get(level).add(node.val);

        for(Node child : node.children) {
            helper(child, result, level+1);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(10, new ArrayList<>());
        Node node2 = new Node(3, new ArrayList<>());
        Node node3 = new Node(2, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());

        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);

        node2.children.add(node5);
        node2.children.add(node6);

        List<List<Integer>> lists = levelOrderRecursive(node1);
        for (List<Integer> list : lists){
            for (Integer val : list){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}

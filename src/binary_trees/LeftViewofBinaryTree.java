package binary_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Left View of Binary Tree
 * https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1#
 */
public class LeftViewofBinaryTree {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    //Recursive Approch
    // TC : O(N)
    // SC : O(N) --> stack space during recursive call
    ArrayList<Integer> leftView1(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    void helper(Node root, ArrayList<Integer> res, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(root.data);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }

    //Iterative Approach
    ArrayList<Integer> leftView2(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();

            // Traverse all nodes of current level
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();

                if (i == 0) { //as we only need a single node value.
                    res.add(node.data);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}

package dsa.binary_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    //--------------------- Iterative ----------------------
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    //------------------  Recursive -------------------------
    public static List<List<Integer>> levelOrderRecursive(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    public static void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(30);

        TreeNode treeNode4 = new TreeNode(40);
        TreeNode treeNode5 = new TreeNode(50);
        TreeNode treeNode6 = new TreeNode(60);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.right = treeNode6;

        List<List<Integer>> res = levelOrderRecursive(treeNode1);
        for (List<Integer> integerList : res) {
            for (Integer val : integerList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

}

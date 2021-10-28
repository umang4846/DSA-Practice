package binary_search_tree;

import java.util.ArrayList;
import java.util.List;
/*
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInaBST {
    /*
     * Approach 1
     * TC : O(N)
     * SC : O(N)
     * */
    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res.get(k - 1);
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    /*
     * Approach 2 --> not visiting and storing all the nodes
     * */
    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        count++;
        if (count == k) result = root.val;
        traverse(root.right, k);
    }
}

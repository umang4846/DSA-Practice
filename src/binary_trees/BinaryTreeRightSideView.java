package binary_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    /*
     * Approach 1 Iterative
     * TC : O(N)
     * SC : O(N)
     * */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            // normal line by line traversal goes from left to right,
            // but we need the right view, so the loop will function from right to left.
            for (int i = count; i > 0; i--) {
                TreeNode curr = queue.poll();

                if (i == count) {
                    res.add(curr.val); //as we only need a single node value.
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
            }
        }
        return res;
    }

    /*
     * Approach 2 Recursive
     * TC : O(N)
     * SC : O(N) -> recursive call stack
     * */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    public void helper(TreeNode root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.val);
        }
        helper(root.right, list, level + 1);
        helper(root.left, list, level + 1);
    }
}

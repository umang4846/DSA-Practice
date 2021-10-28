package binary_trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    //-----------------------Iterative------------------------
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    //----------------------Recursive-------------------------------
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    //---------------------------Moris Traversal - Threaded Tree  --------------------------

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            TreeNode leftNode = curr.left;
            if(leftNode == null){
                res.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode rightMostNode = getRightMostNode(leftNode, curr);
                if(rightMostNode.right == null){ // Create thread
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else{ // cut down thread
                    rightMostNode.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }

    public TreeNode getRightMostNode(TreeNode leftNode, TreeNode curr){
        while(leftNode.right != null && leftNode.right != curr){
            leftNode = leftNode.right;
        }
        return leftNode;
    }
}

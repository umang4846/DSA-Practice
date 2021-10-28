package binary_trees;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    //Recursive
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    //Iterative (Using 2 Stacks)
    public List<Integer> postorderTraversalIterative1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left != null){
                stack1.push(root.left);
            }
            if(root.right!=null){
                stack1.push(root.right);
            }
        }
        while (!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }
}

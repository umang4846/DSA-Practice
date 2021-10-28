package binary_trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    //Iterative
    public static List<Integer> preorderTraversalIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }


    //Recursive
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,result);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        dfs(root.left,result);
        dfs(root.right, result);
    }

    //---------------------------Moris Traversal - Threaded Tree  --------------------------

    public List<Integer> preorderTraversal(TreeNode root) {
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
                    res.add(curr.val);
                    curr = curr.left;
                }else{ // cut down thread
                    rightMostNode.right = null;
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

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(30);;
        TreeNode treeNode4 = new TreeNode(40);
        TreeNode treeNode5 = new TreeNode(50);
        TreeNode treeNode6 = new TreeNode(60);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.right = treeNode6;

        List<Integer> integerList = preorderTraversalIterative(treeNode1);
        for (Integer val : integerList){
            System.out.print(val + " ");
        }
    }


}

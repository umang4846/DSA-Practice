package binary_trees;

import java.util.Stack;

public class PathSum {

    //Iterative
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        nodeStack.push(root);
        numStack.push(sum);

        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int num = numStack.pop();
            if(node.val == num && node.left == null && node.right == null){
                return true;
            }
            if(node.left != null){
                nodeStack.push(node.left);
                numStack.push(num - node.val);
            }
            if(node.right != null){
                nodeStack.push(node.right);
                numStack.push(num - node.val);
            }
        }
        return false;
    }

    //Recursive
    public boolean hasPathSumRecursive(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        targetSum = targetSum - root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        return hasPathSumRecursive(root.left,targetSum) || hasPathSumRecursive(root.right, targetSum);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = null;

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;

        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        treeNode6.left = treeNode9;

        System.out.print(hasPathSum(treeNode1, 22));

    }
}

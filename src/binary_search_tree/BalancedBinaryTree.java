package binary_search_tree;

public class BalancedBinaryTree {

    //Approach 2 TC : O(N)
    public boolean isBalancedRecursive2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return heightRecursive2(root) != -1;
    }
    int heightRecursive2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = heightRecursive2(node.left);
        //check left, if -1 then no need to do check on right subtree
        if(left == -1){
            return -1;
        }
        int right = heightRecursive2(node.right);
        //check right, if -1 then no need to do further calculations
        if(right == -1){
            return -1;
        }
        if (Math.abs(left - right) > 1 ) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    //Approach 1 (TC : O(N^2))
    public boolean isBalancedRecursive1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(heightRecursive1(root.left) - heightRecursive1(root.right)) > 1) {
            return false;
        }
        return isBalancedRecursive1(root.left) && isBalancedRecursive1(root.right);

    }

    int heightRecursive1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(heightRecursive1(node.left), heightRecursive1(node.right));
    }
}

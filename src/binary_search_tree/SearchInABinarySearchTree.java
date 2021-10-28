package binary_search_tree;

public class SearchInABinarySearchTree {

    //Iterative
    public TreeNode searchBSTIterative(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        while(root != null){
            if(root.val  == val){
                return root;
            }
            if(root.val > val){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return null;
    }

    ///Recursive
    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        if(root.val > val){
            return searchBSTRecursive(root.left, val);
        }
        else{
            return searchBSTRecursive(root.right, val);
        }

    }
}

package binary_search_tree;

public class LowestCommonAncestorofaBinarySearchTree {

    //Iterative
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while(node != null){
            if(p.val > node.val && q.val > node.val){
                node = node.right;
            }else if(p.val < node.val && q.val < node.val){
                node = node.left;
            }else{
                return node;
            }
        }
        return null;
    }
    //Recursive
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestorRecursive(root.right, p, q);
        }else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestorRecursive(root.left, p, q);
        }else{
            return root;
        }
    }
}

package dsa.binary_search_tree;

public class InsertintoaBinarySearchTree {

    //Iterative
    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while(true){
            if(cur.val < val) {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }else{
                if(cur.left != null){
                    cur = cur.left;
                }else{
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }


        //Recursive
    public TreeNode insertIntoBSTRecursive(TreeNode root, int val) {

        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left = insertIntoBSTRecursive(root.left, val);
        }else{
            root.right = insertIntoBSTRecursive(root.right, val);
        }
        return root;
    }

}

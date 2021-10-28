package binary_search_tree;

public class DeleteNodeinaBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            if(root.left != null && root.right != null){
                int leftMax = findMax(root.left);
                root.val = leftMax;
                root.left = deleteNode(root.left, leftMax);
                return root;
            }else if(root.left != null){
                return root.left;
            }else if(root.right != null){
                return root.right;
            }else{
                return null;
            }
        }
        return root;
    }

    private int findMax(TreeNode root){
        if(root.right != null){
            return findMax(root.right);
        }else{
            return root.val;
        }
    }

}

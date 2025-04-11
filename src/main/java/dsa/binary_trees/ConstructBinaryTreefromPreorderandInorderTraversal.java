package dsa.binary_trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    int preorderIndex = 0;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap  = new HashMap<>();
        for(int i=0; i<inorder.length;i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return helper(preorder,0,preorder.length-1);
    }

    TreeNode helper(int[] preorder, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, inStart, inorderIndexMap.get(rootValue) - 1);
        root.right = helper(preorder, inorderIndexMap.get(rootValue) + 1 , inEnd);

        return root;
    }
}

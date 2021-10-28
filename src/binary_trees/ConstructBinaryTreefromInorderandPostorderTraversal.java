package binary_trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    //--------------TC : O(N ^ 2 ) ------------------
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        int len = inorder.length - 1;
        return helper1(inorder, postorder, 0, len, 0, len);
    }
    public TreeNode helper1(int[] inorder, int[]postorder, int inStart, int inEnd, int postStart, int postEnd){

        if(inStart > inEnd){
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inStart;
        while(inorder[rootIndex] != rootVal){
            rootIndex++;
        }

        int leftTreeSize = rootIndex - inStart;
        int rightTreeSize = inEnd - rootIndex;

        root.left = helper1(inorder,postorder,inStart,rootIndex-1,postStart,postStart + leftTreeSize - 1);
        root.right = helper1(inorder,postorder,rootIndex + 1, inEnd, postEnd - rightTreeSize, postEnd- 1);

        return root;
    }

    //--------------------- TC : O(N) --------------------------
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        int len = inorder.length - 1;
        return helper2(inorder, postorder, 0, len, 0, len);
    }
    public TreeNode helper2(int[] inorder, int[]postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = map.get(rootVal);

        int leftTreeSize = rootIndex - inStart;
        int rightTreeSize = inEnd - rootIndex;

        root.left = helper2(inorder,postorder,inStart,rootIndex-1,postStart,postStart + leftTreeSize - 1);
        root.right = helper2(inorder,postorder,rootIndex + 1, inEnd, postEnd - rightTreeSize, postEnd- 1);
        return root;
    }
}

package binary_trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);
        return root.val + "," + leftSerialize + "," + rightSerialize;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for(int i =0; i<arr.length; i++){
            queue.add(arr[i]);
        }
        TreeNode root = deserialize(queue);
        return root;
    }
    //Helper function
    public TreeNode deserialize(Queue<String> queue){
        if(queue.size() == 0){
            return null;
        }
        String ele = queue.poll();
        if(ele.equals("X")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(ele));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

}

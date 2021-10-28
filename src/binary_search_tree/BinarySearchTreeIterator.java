package binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTreeIterator {

    //Approach 2
    Stack<TreeNode> stack = new Stack<>();
    public BinarySearchTreeIterator(TreeNode root) {
        partialInorder(root);
    }

    void partialInorder(TreeNode node){
        if(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        partialInorder(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //Approach 1
   /* List<Integer> list = new ArrayList<>();
    int index = 0;
    public BinarySearchTreeIterator(TreeNode root) {
        inorder(root);
    }

    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }*/
}

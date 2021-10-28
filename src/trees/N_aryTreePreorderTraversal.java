package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePreorderTraversal {

    //Iterative
    public List<Integer> preorderIterative(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);

            for(int i = node.children.size() - 1; i>=0; i--){
                stack.push(node.children.get(i));
            }
        }
        return res;
    }


    //Recursive
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root, result);
        return result;
    }

    public void helper(Node root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        for(Node node : root.children){
            helper(node,result);
        }
    }
}

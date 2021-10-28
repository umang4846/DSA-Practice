package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePostorderTraversal {

    //Iterative
    public List<Integer> postorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        LinkedList<Integer> result = new LinkedList<>();
        while(!stack.isEmpty()){
            Node node  = stack.pop();
            result.addFirst(node.val);
            for(Node child : node.children) {
                stack.push(child);
            }
        }
        return result;
    }

    //Recursive
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return null;
        }
        return postorderRecursive(root,res);
    }

    public List<Integer> postorderRecursive(Node root,List<Integer>res) {
        if(root == null){
            return null;
        }
        res.add(root.val);
        for(Node node : root.children){
            postorderRecursive(node,res);
        }
        return res;
    }

}

package recursion;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    //Recursive
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        boolean isLeftSame = isSameTreeRecursive(p.left, q.left);
        boolean isRightSame  = isSameTreeRecursive(p.right, q.right);
        return isLeftSame && isRightSame;
    }

    //Iterative
    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null){
                continue;
            }

            if(left == null || right == null){
                return false;
            }

            if(left.val != right.val){
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.left);
            queue.offer(left.right);
            queue.offer(right.right);
        }
        return true;
    }


}

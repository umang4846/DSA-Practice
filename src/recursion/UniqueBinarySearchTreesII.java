package recursion;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        generateTrees(3);
    }

    public static List<TreeNode> generateTrees(int n) {
        return generateBSTs(1,n);
    }

    private static List<TreeNode> generateBSTs(int start, int end) {
        List<TreeNode> allNode = new ArrayList<>();
        if(start > end){
            allNode.add(null);
            return allNode;
        }
        for(int i= start; i<=end; i++){
            List<TreeNode> leftSubTrees = generateBSTs(start, i-1);
            List<TreeNode> rightSubTress = generateBSTs(i+1, end);
            for(TreeNode leftNode : leftSubTrees){
                for(TreeNode rightNode : rightSubTress){
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    allNode.add(node);
                }
            }
        }
        return allNode;
    }
}

package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backTrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    public void backTrack(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] visited){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(visited[i]){
                continue;
            }
            curr.add(nums[i]);
            visited[i] = true;
            backTrack(res,nums,curr,visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

}

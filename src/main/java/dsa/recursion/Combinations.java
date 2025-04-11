package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        backTrack(list,1,n,k);
        return combinations;
    }

    public void backTrack(List<Integer> list, int start, int n, int k){
        if(list.size ()  == k){
            combinations.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i<=n; i++){
            list.add(i);
            backTrack(list,i+1,n,k);
            list.remove(list.size()-1);
        }

    }


}

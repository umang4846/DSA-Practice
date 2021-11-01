package kunal_kushwaha_dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        //System.out.println(getSubset(new int[]{1,2,3}));
        System.out.println(getSubsetDuplicate(new int[]{1,2,2}));

    }

    static List<List<Integer>> getSubset(int[] arr){

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for (int i = 0; i<n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }

    static List<List<Integer>> getSubsetDuplicate(int[] arr){
        Arrays.sort(arr);

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for(int i = 0; i<arr.length; i++){
            start = 0;
            //if current and previous element is same
            if(i>0 && arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j<n; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }

        return outer;
    }
}


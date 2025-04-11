package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    //Recursive
    public List<Integer> getRowRecursive(int rowIndex) {
        if(rowIndex == 0){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }
        List<Integer> prevList = getRow(rowIndex - 1);
        List<Integer> currList = new ArrayList<>();
        currList.add(1);
        for(int i = 0; i < prevList.size() - 1; i++){
            currList.add(prevList.get(i) + prevList.get(i+1));
        }
        currList.add(1);
        return currList;
    }

    //Memoization
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int [][] memo = new int[rowIndex+1][rowIndex+1];
        for(int i=0;i<=rowIndex;i++){
            list.add(getValue(rowIndex, i, memo));
        }
        return list;
    }

    public static int getValue(int i, int j, int[][] memo){
        if(memo[i][j]==0){
            if(j==0 || j==i){
                memo[i][j]=1;
            } else {
                memo[i][j] = (getValue(i-1,j-1, memo)+getValue(i-1,j, memo));
            }
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        getRow(4);
    }
}

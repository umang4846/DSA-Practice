import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        int[] bridges = new int[]{0, 3000, 4000, 5000, 6000};
        int target = 4;

        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);

        int ans = minimizeConstructionCost(bridges, 1, target, memo);
        System.out.println(ans);

    }

    private static int minimizeConstructionCost(int[] costs, int index, int targetLength, int[] memo) {
        if (targetLength <= 0) {
            return 0;
        }

        if(index >= costs.length){
            return Integer.MAX_VALUE;
        }

        if (memo[targetLength] != -1) {
            return memo[targetLength];
        }

        int take = Integer.MAX_VALUE;
        int notTake;
        for (int start = index; start < costs.length; start++) {
            if (start <= targetLength) {
                take = costs[start] + minimizeConstructionCost(costs, start + 1, targetLength - start, memo);
            }
        }

        notTake = minimizeConstructionCost(costs, index + 1, targetLength, memo);

        return memo[index] = Math.min(take, notTake);

    }
}



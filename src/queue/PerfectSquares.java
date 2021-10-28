package queue;

public class PerfectSquares {

    public int numSquares(int n) {

       // Using Resursion + Memoization
        int[] momo = new int [n + 1];
        return recursionAndMemoization(n, momo);

    }

    public int recursionAndMemoization(int n, int[] memo){
        if(n == 0){
            return 0;
        }
        if(memo[n] != 0){
            return memo[n];
        }
        memo[n] = n;
        for(int i = 1; i * i <= n; i++){
            memo[n] = Math.min(memo[n], 1 + recursionAndMemoization(n - i * i, memo));
        }
        return memo[n];
    }

    //Using recursion
    public int recursiveApproach(int n){
        if(n <= 3){
            return n;
        }
        int ans = n;
        for(int i = 1; i * i <= n; i++){
            ans = Math.min(ans, 1 + recursiveApproach(n-i*i));
        }
        return ans;
    }


    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.recursiveApproach(5));
    }

}

package dsa.recursion;

public class KthSymbolinGrammar {
    //Recursive
    public int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) {
            return 0;
        }
        int mid = (int) Math.pow(2, n - 1) / 2;
        if (k <= mid) {
            return kthGrammar(n - 1, k);
        } else {
            if (kthGrammar(n - 1, k - mid) == 0) {
                return 1;
            }
            return 0;
        }
    }
}

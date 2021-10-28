package binary_search;

public class ValidPerfectSquare {
    //using mid as long variable to avoid overflow condition
    //TC : O(logNum)
    //SC : O(1)
    public boolean isPerfectSquare(int num) {
        int i = 0;
        int j = num;

        if (num <= 1) {
            return true;
        }
        while (i <= j) {
            long mid = i + (j - i) / 2; // to avoid overflow in case (left+right)>2147483647
            if (mid * mid == num) {
                return true;
            }
            if (mid * mid < num) {
                i = (int) mid + 1;
            } else {
                j = (int) mid - 1;
            }
        }
        return false;
    }
}

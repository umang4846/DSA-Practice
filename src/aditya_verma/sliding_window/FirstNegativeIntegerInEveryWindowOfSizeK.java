package aditya_verma.sliding_window;

import java.util.Arrays;
import java.util.LinkedList;

public class FirstNegativeIntegerInEveryWindowOfSizeK {
    public static void main(String[] args) {
        long[] arr = {-8, 2, 3, -6, 10};
        System.out.println(Arrays.toString(printFirstNegativeInteger(arr, arr.length, 2)));

    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        long[] ans = new long[N - K + 1];
        int index = 0;
        int i = 0;
        int j = 0;

        LinkedList<Long> list = new LinkedList<>();
        while (j < N) {
            if (A[j] < 0) {
                list.add(A[j]);
            }
            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                if (list.size() == 0) {
                    ans[index++] = 0;
                } else {
                    ans[index++] = list.peekFirst();
                    if(A[i] == list.peekFirst()){
                        list.pollFirst();
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Test {

   /* @Override
    public int sum(int a, int b) {
        return Interface1.super.sum(a, b);
    }
    */
   /* public int sum(int a, int b){
        return Interface1.sum(a,b);
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{10, 9, 8,7,6,5,4,3,2,1};

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            mergeArray(arr, start, mid, end);
        }

    }

    private static void mergeArray(int[] arr, int start, int mid, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int i = 0; i < mid - start + 1; i++) {
            left[i] = arr[start + i];
        }
        for (int j = 0; j < end - mid; j++) {
            right[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = start;
        while (i < mid - start + 1 && j < end - mid) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < mid - start + 1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < end - mid) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }
}



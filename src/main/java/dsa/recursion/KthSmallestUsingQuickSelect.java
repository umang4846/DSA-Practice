package dsa.recursion;

import java.util.Scanner;

public class KthSmallestUsingQuickSelect {
    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        int pi = partition(arr, lo, hi);
        int ktemp = k-1;
        if (pi == ktemp) {
            return arr[pi];
        } else if (pi > ktemp) {
            return quickSelect(arr, lo, pi - 1, k);
        } else {
            return quickSelect(arr, pi + 1, hi, k);
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(quickSelect(arr, 0, arr.length - 1, k));
    }
}

package dsa.sorting;

import java.util.Arrays;

public class CountingSort {

    private static void countingSort(int[] arr) {
        //get min element
        int max = Arrays.stream(arr).max().getAsInt();
        //get max element
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] frequency = new int[range];
        //count frequency of each element
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - min;
            frequency[index]++;
        }

        //store prefix sum of each element into array
        for (int i = 1; i < frequency.length; i++) {
            frequency[i] = frequency[i] + frequency[i - 1];
        }

        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            //value
            int val = arr[i];
            //frequency position
            int pos = frequency[val - min];
            //position - 1 for array index
            int index = pos - 1;
            //store array value into appropriate index
            output[index] = val;
            //decrease position by 1
            frequency[val - min]--;
        }

        // store auxiliary array into input array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 4, 3, 6, 1, 9};
        countingSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }


}

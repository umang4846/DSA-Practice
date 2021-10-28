package sorting;

import java.util.Arrays;

public class RadixSort {

    private static void radixSort(int[] arr, int exp) {
        int[] frequency = new int[10];
        //count frequency of each element
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] / exp) % 10;
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
            int pos = frequency[(arr[i] / exp) % 10];
            //position - 1 for array index
            int index = pos - 1;
            //store array value into appropriate index
            output[index] = val;
            //decrease position by 1
            frequency[(arr[i] / exp) % 10]--;
        }

        // store auxiliary array into input array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > max){
                max = num;
            }
        }
        int exp = 1;
        while(exp <= max){
            radixSort(arr, exp);
            exp = exp * 10;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}

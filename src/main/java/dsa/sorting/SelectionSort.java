package dsa.sorting;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for(int i = 0; i<arr.length-1;i++){
            int minIndex = i;
            for(int j = i + 1; j<arr.length; j++){
                if(arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }
    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 1, 6, 4};
        selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

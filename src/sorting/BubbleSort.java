package sorting;

public class BubbleSort {

    private static void bubbleSort(int[] arr) {
        boolean swapped;
        for(int i = 0; i<arr.length - 1;i++){
            swapped = false;
            for(int j = 0; j < arr.length - i -1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            // if you did not swap for a particular value of i, it means the array is sorted hence stop the program
            if (!swapped) { // !false = true
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        bubbleSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }


}

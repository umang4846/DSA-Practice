package dsa.recursion;

public class QuickSort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    //Start from here
    public void quickSort(int[] nums, int start, int end){
        if(start < end){
            int pivotIndex = partition(nums, start, end);
            quickSort(nums, start, pivotIndex);
            quickSort(nums, pivotIndex + 1, end);
        }
    }
    public int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        while(start <= end){
            while(nums[start] < pivot){
                start++;
            }
            while(nums[end] > pivot){
                end--;
            }
            if(start <= end){
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        return end;
    }
    public void swap(int[] nums, int start, int end){
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
    }
}

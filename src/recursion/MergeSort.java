package recursion;

public class MergeSort {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            int[] smallAns = new int[1];
            smallAns[0] = nums[start];
            return smallAns;
        }
        int mid = (start + end) / 2;
        int[] leftSortedArray = mergeSort(nums, start, mid);
        int[] rightSortedArray = mergeSort(nums, mid + 1, end);
        return mergeTwoSortedArray(leftSortedArray, rightSortedArray);
    }

    private int[] mergeTwoSortedArray(int[] leftSortedArray, int[] rightSortedArray) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] sortedArray = new int[leftSortedArray.length + rightSortedArray.length];
        while (i < leftSortedArray.length && j < rightSortedArray.length) {
            if (leftSortedArray[i] < rightSortedArray[j]) {
                sortedArray[k++] = leftSortedArray[i++];
            } else {
                sortedArray[k++] = rightSortedArray[j++];
            }
        }
        while (i < leftSortedArray.length) {
            sortedArray[k++] = leftSortedArray[i++];
        }
        while (j < rightSortedArray.length) {
            sortedArray[k++] = rightSortedArray[j++];
        }
        return sortedArray;
    }
}

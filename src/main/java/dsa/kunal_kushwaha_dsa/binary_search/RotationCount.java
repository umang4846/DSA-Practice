package dsa.kunal_kushwaha_dsa.binary_search;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(findPivot(arr, 0, arr.length - 1) + 1);
    }

    private static int findPivot(int[] arr, int start, int end) {
        int mid = start + (end - start) / 2;
        if (mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid < start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }
        if (arr[mid] <= arr[start]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return -1;
    }
}

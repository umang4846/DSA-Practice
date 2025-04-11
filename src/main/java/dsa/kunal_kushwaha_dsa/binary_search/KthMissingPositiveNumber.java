package dsa.kunal_kushwaha_dsa.binary_search;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));

    }

    public static int findKthPositive(int[] arr, int k) {
        int count = 1;
        int index = 0;
        while (index < arr.length && k > 0) {
            if (arr[index] != count) {
                k--;
            } else {
                index++;
            }
            count++;
        }
        while (k > 0) {
            count++;
            k--;
        }
        return count-1;
    }
}

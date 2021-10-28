package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public void bucketSort(float[] arr, int n) {
        if (n <= 1)
            return;
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] bucket = new ArrayList[n];

        // Create empty buckets
        for (int i = 0; i < n; i++)
            bucket[i] = new ArrayList<Float>();

        // Add elements into the buckets
        for (int i = 0; i < n; i++) {
            //if number which integral part is greater than 0
            if ((int) arr[i] > 0) {
                int bucketIndex = (int) arr[i] / 10 * n;
                bucket[bucketIndex].add(arr[i]);
            } else {
                int bucketIndex = (int) arr[i] * n;
                bucket[bucketIndex].add(arr[i]);
            }
        }

        // Sort the elements of each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort((bucket[i]));
        }

        // Get the sorted array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        BucketSort b = new BucketSort();
        float[] arr = {0.42f, 0.32f, 1.33f, 0.52f, 5.37f, 0.47f, 0.51f};
        b.bucketSort(arr, 7);

        for (float i : arr)
            System.out.print(i + "  ");
    }
}

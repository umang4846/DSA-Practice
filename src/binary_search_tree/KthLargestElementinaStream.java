package binary_search_tree;

import java.util.PriorityQueue;

public class KthLargestElementinaStream {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargestElementinaStream(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>(k);

        for(int num:nums){
            pq.add(num);
            if(pq.size()>k) pq.remove();
        }
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size()>k){
            pq.remove();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestElementinaStream kthLargest = new KthLargestElementinaStream(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
    }

}

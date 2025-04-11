package dsa.priority_queue;


public class DesignMaxHeap {
    int[] maxHeap;
    int heapSize;
    int realSize = 0;

    public DesignMaxHeap(int heapSize) {
        this.heapSize = heapSize;
        maxHeap = new int[heapSize + 1];
        maxHeap[0] = 0;
    }

    public int size() {
        return realSize;
    }

    public int peek() {
        if (realSize < 1) {
            System.out.println("Heap is Empty!");
            return Integer.MIN_VALUE;
        }
        return maxHeap[1];
    }

    public String toString() {
        if (realSize == 0) {
            return "Heap is Empty!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 1; i <= realSize; i++) {
            sb.append(maxHeap[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public void add(int element) {
        realSize++;
        if (realSize > heapSize) {
            System.out.println("Added too many elements");
            realSize--;
            return;
        }
        maxHeap[realSize] = element;
        int index = realSize;
        int parent = index / 2;

        while (maxHeap[index] > maxHeap[parent] && index > 1) {
            int temp = maxHeap[index];
            maxHeap[index] = maxHeap[parent];
            maxHeap[parent] = temp;
            index = parent;
            parent = index / 2;
        }
    }

    public int poll() {
        if (realSize == 0) {
            System.out.println("Heap is Empty!");
            return Integer.MIN_VALUE;
        }
        int removedElement = maxHeap[1];
        maxHeap[1] = maxHeap[realSize];
        realSize--;
        int index = 1;
        while (index <= realSize / 2) {
            int left = index * 2;
            int right = index * 2 + 1;
            if (maxHeap[index] < maxHeap[left] || maxHeap[index] < maxHeap[right]) {
                if (maxHeap[left] > maxHeap[right]) {
                    int temp = maxHeap[left];
                    maxHeap[left] = maxHeap[index];
                    maxHeap[index] = temp;
                    index = left;
                } else {
                    int temp = maxHeap[right];
                    maxHeap[right] = maxHeap[index];
                    maxHeap[index] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }
        return removedElement;
    }


    public static void main(String[] args) {
        DesignMaxHeap maxheap = new DesignMaxHeap(10);
        maxheap.add(3);
        maxheap.add(1);
        maxheap.add(2);
        maxheap.add(4);
        maxheap.add(8);
        maxheap.add(11);
        maxheap.add(15);
        maxheap.add(18);
        maxheap.add(20);
        maxheap.add(30);
        maxheap.add(22);
        maxheap.add(14);

        // [1,3,2]
        System.out.println(maxheap.toString());
        // 1
        System.out.println(maxheap.peek());
        // 1
        System.out.println(maxheap.poll());
        // [2, 3]
        System.out.println(maxheap.toString());
        maxheap.add(19);
        System.out.println(maxheap.toString());
        // Add too many elements
        maxheap.add(55);
        // [2,3,4]
        System.out.println(maxheap.toString());
    }
}

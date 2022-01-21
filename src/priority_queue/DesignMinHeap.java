package priority_queue;

public class DesignMinHeap {

    int[] minHeap;
    int heapSize;
    int realSize = 0;

    public DesignMinHeap(int heapSize) {
        this.heapSize = heapSize;
        minHeap = new int[heapSize + 1];
        minHeap[0] = 0; //put 0 at 0th index to calculate indexes in simple way
    }

    public void add(int element) {
        realSize++;
        if (realSize > heapSize) {
            System.out.println("Added too many elements!");
            realSize--;
            return;
        }
        minHeap[realSize] = element;
        int index = realSize;
        int parent = index / 2;
        while (minHeap[index] < minHeap[parent] && index > 1) {
            int temp = minHeap[index];
            minHeap[index] = minHeap[parent];
            minHeap[parent] = temp;
            index = parent;
            parent = index / 2;
        }
    }

    public int poll() {
        if (realSize < 1) {
            System.out.println("Heap is Empty!");
            return Integer.MAX_VALUE;
        }
        int removedElement = minHeap[1];
        minHeap[1] = minHeap[realSize];
        realSize--;
        int index = 1;

        while (index <= realSize / 2) {
            int left = index * 2;
            int right = index * 2 + 1;
            if (minHeap[index] > minHeap[left] || minHeap[index] > minHeap[right]) {
                if (minHeap[left] < minHeap[right]) {
                    int temp = minHeap[left];
                    minHeap[left] = minHeap[index];
                    minHeap[index] = temp;
                    index = left;
                } else {
                    int temp = minHeap[right];
                    minHeap[right] = minHeap[index];
                    minHeap[index] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }
        return removedElement;

    }

    public int peek() {
        if (realSize < 1) {
            System.out.println("Heap is Empty!");
            return Integer.MAX_VALUE;
        }
        return minHeap[1];
    }

    public int size() {
        return realSize;
    }

    public String toString() {
        if (realSize == 0) {
            return "Heap is Empty!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 1; i <= realSize; i++) {
            sb.append(minHeap[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DesignMinHeap minHeap = new DesignMinHeap(15);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(4);
        minHeap.add(8);
        minHeap.add(11);
        minHeap.add(15);
        minHeap.add(18);
        minHeap.add(20);
        minHeap.add(30);
        minHeap.add(22);
        minHeap.add(14);
        // [1,3,2]
        System.out.println(minHeap.toString());
        // 1
        System.out.println(minHeap.peek());
        // 1
        System.out.println(minHeap.poll());
        // [2, 3]
        System.out.println(minHeap.toString());
        minHeap.add(19);
        // Add too many elements
        minHeap.add(55);
        // [2,3,4]
        System.out.println(minHeap.toString());
    }

}

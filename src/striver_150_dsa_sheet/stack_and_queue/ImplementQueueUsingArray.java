package striver_150_dsa_sheet.stack_and_queue;

public class ImplementQueueUsingArray {

    int front, rear;
    int arr[] = new int[100005];

    ImplementQueueUsingArray() {
        front = 0;
        rear = 0;
    }

    //Function to push an element x in a queue.
    void push(int x) {
        arr[rear] = x;
        rear++;
    }

    //Function to pop an element from queue and return that element.
    int pop() {
        if (rear == 0) {
            return -1;
        }
        int val = arr[front];
        front++;
        if (front == rear) {
            front = 0;
            rear = 0;
        }
        return val;
    }

}

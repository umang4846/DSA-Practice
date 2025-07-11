package dsa.queue;

import java.util.Arrays;

class MyCircularQueue {

    public static void main(String[] args){
        MyCircularQueue myCircularQueue = new MyCircularQueue(81);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());// return 4
    }

    int[] q;
    int front=0,rear=0,size=0;

    public MyCircularQueue(int k) {
        q=new int[k];
        Arrays.fill(q,-1);
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            front=0;
            rear=0;
            q[rear]=value;
            size++;
            return true;
        }

        rear++;
        size++;
        rear = rear %q.length;
        q[rear]=value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        q[front]=-1;
        size--;
        front++;
        front = front % q.length;
        return true;
    }

    public int Front() {
        return q[front];
    }

    public int Rear() {
        return q[rear];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==q.length;
    }
}

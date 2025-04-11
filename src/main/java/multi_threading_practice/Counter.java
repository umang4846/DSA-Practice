package multi_threading_practice;

public class Counter {
    int counter;

    public synchronized void increment() {
        counter++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCounter() {
        return counter;
    }
}

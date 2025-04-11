package multi_threading_practice;

public class Test extends Thread {
    Counter counter;

    Test(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            counter.increment();
        }
    }

}

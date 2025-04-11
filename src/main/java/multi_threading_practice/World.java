package multi_threading_practice;

public class World {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Test t1 = new Test(c);
        Test t2 = new Test(c);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.getCounter());
    }
}

package multithreading;

public class Company {
    int n;
    boolean f = true;
    //if f is true then chance of producer
    //if f is false then chance of consumer
    synchronized public void produce_item(int n) throws InterruptedException {
        if(!f){
            wait();
        }
        this.n  = n;
        System.out.println("Produced : "+this.n);
        f = false;
        notify();

    }
    synchronized public int consume_item() throws InterruptedException {
        if(f){
            wait();
        }
        System.out.println("Consumed : "+this.n);
        f = true;
        notify();
        return this.n;
    }
}

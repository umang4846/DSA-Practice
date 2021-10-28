package multithreading;

public class ConsumerThred extends Thread{

    Company company;

    ConsumerThred(Company company){
        this.company = company;
    }

    @Override
    public void run() {
        while(true){
            try {
                this.company.consume_item();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

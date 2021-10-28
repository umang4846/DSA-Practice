package multithreading;

public class ProducerThread extends Thread{
    Company company;

    ProducerThread(Company company){
        this.company = company;
    }

    @Override
    public void run() {
        int i = 1;
        while(true){
            try {
                this.company.produce_item(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}

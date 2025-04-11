package multithreading;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        ProducerThread producer = new ProducerThread(company);
        ConsumerThred consumer = new ConsumerThred(company);
        producer.start();
        consumer.start();
    }

}

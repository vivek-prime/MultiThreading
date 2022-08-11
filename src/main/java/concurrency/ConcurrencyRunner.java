package concurrency;

public class ConcurrencyRunner {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterTask thread1 = new CounterTask(counter, "t1", 1);
        CounterTask thread2 = new CounterTask(counter, "t2", 2);
        CounterTask thread3 = new CounterTask(counter, "t3", 3);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println(counter.getI());
    }
}

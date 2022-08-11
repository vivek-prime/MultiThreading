package concurrency.multithreadingWithSynchronized;

import lombok.Data;

@Data
public class CounterTask extends Thread {
    private Counter counter;
    private int incValue;

    public CounterTask(Counter counter, String threadName, int incValue) {
        super(threadName);
        this.counter = counter;
        this.incValue = incValue;
    }

    @Override
    public void run() {
        synchronized (counter) {
            System.out.println("Thread Entered - " + Thread.currentThread().getName());
            int temp = counter.getI();
            System.out.println(Thread.currentThread().getName() + " - get value - " + temp);
            temp++;
            counter.setI(temp);
            System.out.println(Thread.currentThread().getName() + " - set value - " + temp);
            System.out.println("Thread died - " + Thread.currentThread().getName());
        }
    }
}

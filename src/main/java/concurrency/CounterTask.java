package concurrency;

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
        System.out.println(Thread.currentThread().getName() + " reads value - " + counter.getI());
        counter.increment(incValue);
        System.out.println(Thread.currentThread().getName() + " sets value - " + counter.getI());
    }
}

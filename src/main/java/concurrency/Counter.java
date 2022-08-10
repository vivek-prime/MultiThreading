package concurrency;

import lombok.Data;

@Data
/**
 * Shared class
 */
public class Counter {
    private int i;

    public void increment(int incValue) {
        i += incValue;
    }
}

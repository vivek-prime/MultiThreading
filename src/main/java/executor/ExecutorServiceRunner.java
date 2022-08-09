package executor;

import model.Task1;
import model.Task2;
import model.Task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        add tasks to executor service
        executorService.execute(new Task1(2));
        executorService.execute(new Task2(5));
        executorService.execute(new Task3(11));

//        shutdown executor service
        executorService.shutdown();
    }
}

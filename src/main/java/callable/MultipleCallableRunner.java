package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultipleCallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

//        create list of tasks
        List<Callable<List<String>>> callableList = new ArrayList<>();
        callableList.add(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return List.of("Vivek", "Choti");
            }
        });
        callableList.add(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return List.of("Dhanbad", "Asansol");
            }
        });
        List<Future<List<String>>> futures = executorService.invokeAll(callableList);
        for (Future<List<String>> future : futures) {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}

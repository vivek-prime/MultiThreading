import java.util.concurrent.*;

public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        add tasks to executor service
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum += i;
                }
                return "First Task - " + sum;
            }
        });
//        future is a promise that it makes to give us a result
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleAnyCallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

//        create list of tasks
        List<Callable<List<String>>> callableList = new ArrayList<>();
        callableList.add(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                Thread.sleep(1000);
                return List.of("Vivek", "Choti");
            }
        });
        callableList.add(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return List.of("Dhanbad", "Asansol");
            }
        });
        List<String> anySingleResult = executorService.invokeAny(callableList);
        System.out.println(anySingleResult);
        executorService.shutdown();
    }
}

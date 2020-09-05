package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//https://www.baeldung.com/java-future
public class Calculator {

    private ExecutorService executor
            = Executors.newSingleThreadExecutor();

    public Future<Integer> calculateSquared(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }

    public Future<Integer> calculateSquaredVersion2(Integer input) {
        var callable = new Callable<Integer>(){

            @Override
            public Integer call() throws Exception {
                return input * input;
            }
        };

        return executor.submit(callable);
    }

    


}

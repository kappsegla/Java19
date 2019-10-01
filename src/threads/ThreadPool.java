package threads;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService executor =
                 Executors.newScheduledThreadPool(2);
        executor.submit(() -> {
            System.out.println("Task 1 running");
            Thread.sleep(1000);
            return null;
        });
        executor.schedule(() -> {
            System.out.println("Task 2 running");
            Thread.sleep(1000);
            return null;
        },5000, TimeUnit.MILLISECONDS);

        executor.submit(() -> {
            System.out.println("Task 3 running");
            Thread.sleep(1000);
            return null;
        });

    }
}

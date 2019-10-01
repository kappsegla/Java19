package threads;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadsExample implements Runnable {

    public boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        ThreadsExample threadsExample = new ThreadsExample();
        Thread thread = new Thread(threadsExample);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter key to interrupt thread");
        scanner.nextLine();
        threadsExample.stop = true;
     //   thread.interrupt();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " says hi!");

        while (!stop) {
            System.out.println(Thread.currentThread().getName() + " going to sleep.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
            System.out.println(Thread.currentThread().getName() + " woke up.");
        }
    }
}

package threads;

import java.util.Scanner;

public class ThreadsExample implements Runnable {

    public boolean doWork = true;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadsExample threadsExample = new ThreadsExample();
        Thread thread = new Thread(threadsExample);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter key to interrupt thread");
        scanner.nextLine();
        threadsExample.doWork = false;
        thread.interrupt();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " says hi!");

        while (doWork) {
            System.out.println(Thread.currentThread().getName() + " going to sleep.");
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
            System.out.println(Thread.currentThread().getName() + " woke up.");
        }
    }
}

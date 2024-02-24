/**
 * Concurrency using ExecutorService
 */
package concurrencysample;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SampleExecutor { // Main Class
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10); // Create 10 Threads
        for(int i = 1; i <= 12; i++)
            executor.execute(new RunnableThread()); // These 12 tasks (RunnableThreads) is distributed among the 10 created threads.
        executor.shutdown();
    } // end of main method
} // end of SampleExecutor

class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Me is thread, me say hello!");
    }
} // end of RunnableThread class
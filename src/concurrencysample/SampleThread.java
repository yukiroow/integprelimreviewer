/**
 * Concurrency by extending the Thread class
 */
package concurrencysample;

public class SampleThread extends Thread {
    private int max;
    SampleThread(int number, String id) {
        super(id);
        max = number;
    }

    @Override
    public void run() {
        for(int i = 1; i <= max; i++)
            System.out.println(this.getName() + ": printing " + i);
    }

    public static void main(String[] args) {
        SampleThread thread1 = new SampleThread(10, "Thread Uno");
        SampleThread thread2 = new SampleThread(12, "Thread Dos");
        SampleThread thread3 = new SampleThread(14, "Thread Tres");

        // Start all threads at the same time
        thread1.start();
        thread2.start();
        thread3.start();

        try { // Execute all threads before continuing main thread
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Last line of main thread reached...");
    }
} // end of SampleThread class
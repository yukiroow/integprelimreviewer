/**
 * Concurrency sample through Implementing Runnable
 */
package concurrencysample;

public class SampleRunnable { // Main Class
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SampleRunnableThread(10, "Thread 1"));
        Thread thread2 = new Thread(new SampleRunnableThread(12, "Thread 2"));
        Thread thread3 = new Thread(new SampleRunnableThread(14, "Thread 3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
} // end of Sample Runnable

class SampleRunnableThread implements Runnable { // Thread Class
    int max;
    String name;

    SampleRunnableThread(int number, String id) {
        max = number;
        name = id;
    }

    @Override
    public void run() {
        for(int i = 0; i <= max; i++)
            System.out.println(name + ": printing " + i);
    }
} // end of SampleRunnableThread
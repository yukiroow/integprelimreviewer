/**
 * Concurrency through Lambda Expressions
 */
package concurrencysample;

public class SampleLambda {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for(int i = 1; i <= 12; i++)
                System.out.println("Thread 1: printing " + i);
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 1; i <= 14; i++)
                System.out.println("Thread 2: printing " + i);
        });
        Thread thread3 = new Thread(() -> {
            for(int i = 1; i <= 16; i++)
                System.out.println("Thread 3: printing " + i);
        });
        thread1.start();
        thread2.start();
        thread3.start();
    } // end of main method
} // end of Sample Lambda
/**
 * This application displays the averages of given values
 * using the ExecutorService, Future, and Callable<> classes.
 */
package concurrencysample;
import java.util.*;
import java.util.concurrent.*;

public class SampleCallable {
    public static void main(String[] args) {
        ExecutorService threads = Executors.newFixedThreadPool(10);

        List<Future<Result>> list = new ArrayList<>();
        for(int i = 1; i <= 12; i++) {
            Callable<Result> task = new SampleCallableObject(i);
            list.add(threads.submit(task)); // the submit() method returns a Future Object
        }
        threads.shutdown(); // Shutdown all threads

        System.out.println("Results::");
        for(Future<Result> future: list)
            try {
                System.out.println(future.get()); // Display All Averages
            } catch (ExecutionException | InterruptedException e) {
                System.out.println("Error :P");
            }
    } // end of main method
} // end of SampleCallable class

class Result { // Where result of computing in SampleCallableObject is saved
    private int max;
    private double result;

    Result(int max, double result) {
        this.max = max;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Average from 1 to " + max + ": " + result;
    }
} // end of Result class

class SampleCallableObject implements Callable<Result> {
    private int max;

    SampleCallableObject(int max) {
        this.max = max;
    }

    @Override
    public Result call() {
        long sum = 0;
        double average;
        for(long i = 1; i <= max; i++)
            sum += i;
        average = (double) sum/max; // Compute for the Average
        return new Result(max, average); // Return results
    }
} // end of SampleCallableObject
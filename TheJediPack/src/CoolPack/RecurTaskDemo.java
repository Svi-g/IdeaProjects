package CoolPack;
// A simple example that uses RecursiveTask<V>.
import java.util.concurrent.*;

// A RecursiveTask that computes the summation of an array of doubles.
class Summation extends RecursiveTask<Double> {
    // The sequential threshold value.
    final int seqThresHold = 500;
    // Array to be accessed.
    double[] data;
    // Determines what part of data to process.
    int start, end;
    Summation(double[] vals, int s, int e ) {
        data = vals;
        start = s;
        end = e;
    }
    // Find the summation of an array of doubles.
    protected Double compute() {
        double sum = 0;
// If number of elements is below the sequential threshold,
// then process sequentially.
        if((end - start) < seqThresHold) {
// Sum the elements.
            for(int i = start; i < end; i++) sum += data[i];
        }
        else {
// Otherwise, continue to break the data into smaller pieces.
// Find the midpoint.
            int middle = (start + end) / 2;
// Invoke new tasks, using the subdivided data.
            Summation subTaskA = new Summation(data, start, middle);
            Summation subTaskB = new Summation(data, middle, end);
// Start each subtask by forking.
            subTaskA.fork();
            //subTaskB.fork();
// Wait for the subtasks to return, and aggregate the results.
            //sum = subTaskA.join() + subTaskB.join();
            //sum = subTaskB.compute() + subTaskA.join(); //executing simultaneously example
            sum = subTaskB.invoke() + subTaskA.join(); //executing simultaneously example

        }
// Return the final sum.
        return sum;
    }
}

public class RecurTaskDemo {
    public static void main(String... args) {
        double summation;
        try (ForkJoinPool fjp = new ForkJoinPool()) {
            double[] nums = new double[5000];
// Initialize nums with values that alternate between
// positive and negative.
            for (int i = 0; i < nums.length; i++)
                nums[i] = ((i % 2) == 0) ? i : -i;
            Summation task = new Summation(nums, 0, nums.length);
// Start the ForkJoinTasks. Notice that, in this case,
// invoke() returns a result.
            summation = fjp.invoke(task);
        }
        System.out.println("Summation " + summation);
    }
}

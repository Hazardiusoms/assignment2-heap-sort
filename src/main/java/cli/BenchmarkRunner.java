package cli;

import algorithms.HeapSort;
import metrics.PerfomanceTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {

        int[] sizes = {100, 1000, 10000, 100000};
        Random rnd = new Random();


        File folder = new File("docs/performance-plots");
        if (!folder.exists()) {
            folder.mkdirs();
        }


        File outFile = new File(folder, "results.csv");

        try (PrintWriter writer = new PrintWriter(new FileWriter(outFile))) {

            writer.println(PerfomanceTracker.csvHeader());


            for (int n : sizes) {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = rnd.nextInt();
                }

                PerfomanceTracker tracker = new PerfomanceTracker();
                tracker.startTimer();
                HeapSort.heapSort(arr, tracker);
                tracker.stopTimer();

                writer.println(tracker.toCsvRow(n));
            }
        }

        System.out.println("."+ outFile.getAbsolutePath());
    }
}

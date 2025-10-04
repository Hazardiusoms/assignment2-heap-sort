package algorithms;

import metrics.PerfomanceTracker;
import java.util.Objects;

public class HeapSort {

    public static void heapSort(int[] a, PerfomanceTracker tracker) {
        Objects.requireNonNull(a);
        int n = a.length;
        if (n < 2) return;


        for (int i = parent(n - 1); i >= 0; i--) {
            siftDown(a, i, n, tracker);
        }
        for (int end = n - 1; end > 0; end--) {
            swap(a, 0, end, tracker);
            siftDown(a, 0, end, tracker);
        }
    }

    private static int parent(int i){ return (i - 1) / 2; }

    private static void siftDown(int[] a, int root, int n, PerfomanceTracker tracker) {
        while (true) {
            int child = root * 2 + 1;
            if (child >= n) break;
            int swapIdx = root;

            tracker.incArrayAccesses(1);
            tracker.incComparisons();
            if (a[swapIdx] < a[child]) swapIdx = child;

            if (child + 1 < n) {
                tracker.incArrayAccesses(1);
                tracker.incComparisons();
                if (a[swapIdx] < a[child + 1]) swapIdx = child + 1;
            }

            if (swapIdx == root) break;
            swap(a, root, swapIdx, tracker);
            root = swapIdx;
        }
    }

    private static void swap(int[] a, int i, int j, PerfomanceTracker tracker) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        tracker.incSwaps();
        tracker.incArrayAccesses(2);
    }
}

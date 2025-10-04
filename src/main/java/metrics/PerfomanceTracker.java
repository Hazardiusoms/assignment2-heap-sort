package metrics;

import java.io.*;
import java.util.*;

public class PerfomanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long startNs = 0;
    private long endNs = 0;

    public void startTimer(){ startNs = System.nanoTime(); }
    public void stopTimer(){ endNs = System.nanoTime(); }
    public long getElapsedNs(){ return endNs - startNs; }

    public void incComparisons(){ comparisons++; }
    public void incSwaps(){ swaps++; }
    public void incArrayAccesses(long x){ arrayAccesses += x; }

    public long getComparisons(){ return comparisons; }
    public long getSwaps(){ return swaps; }
    public long getArrayAccesses(){ return arrayAccesses; }


    public static String csvHeader() {
        return "n,elapsed_ns,comparisons,swaps,array_accesses";
    }
    public String toCsvRow(int n) {
        return String.format("%d,%d,%d,%d,%d", n, getElapsedNs(), comparisons, swaps, arrayAccesses);
    }
}

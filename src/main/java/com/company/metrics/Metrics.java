package com.company.metrics;

public class Metrics {
    private int comparisons;
    private int swaps;
    private int recursiveCalls;
    private int maxDepth;
    private int currentDepth;

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void incrementRecursiveCalls() {
        recursiveCalls++;
    }

    public void enterDepth() {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    public void exitDepth() {
        currentDepth--;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        recursiveCalls = 0;
        maxDepth = 0;
        currentDepth = 0;
    }


    public int getComparisons() { return comparisons; }
    public int getSwaps() { return swaps; }
    public int getRecursiveCalls() { return recursiveCalls; }
    public int getMaxDepth() { return maxDepth; }
}

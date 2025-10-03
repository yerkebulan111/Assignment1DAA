package com.company.metrics;

public class Metrics {
    private int comparisons;
    private int allocations;
    private int maxDepth;
    private int currentDepth;

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementAllocations() {
        allocations++;
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
        allocations = 0;
        maxDepth = 0;
        currentDepth = 0;
    }

    public int getComparisons() { return comparisons; }
    public int getAllocations() { return allocations; }
    public int getMaxDepth() { return maxDepth; }
}

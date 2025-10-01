package com.company.sorts.quicksort;

import com.company.metrics.Metrics;
import com.company.util.SortUtils;

public class QuickSortRandomPivot {

    public static void sort(int[] arr, Metrics metrics) {
        quickSort(arr, 0, arr.length - 1, metrics);
    }

    private static void quickSort(int[] arr, int low, int high, Metrics metrics) {
        if (low < high) {
            metrics.incrementRecursiveCalls();
            metrics.enterDepth();

            int pivotIndex = SortUtils.partition(arr, low, high, metrics);
            quickSort(arr, low, pivotIndex - 1, metrics);
            quickSort(arr, pivotIndex + 1, high, metrics);

            metrics.exitDepth();
        }
    }
}

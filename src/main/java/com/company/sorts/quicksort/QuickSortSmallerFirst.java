package com.company.sorts.quicksort;

import com.company.metrics.Metrics;
import com.company.util.SortUtils;

public class QuickSortSmallerFirst {

    public static void sort(int[] arr, Metrics metrics) {
        quickSort(arr, 0, arr.length - 1, metrics);
    }

    private static void quickSort(int[] arr, int low, int high, Metrics metrics) {
        while (low < high) {
            metrics.incrementRecursiveCalls();
            metrics.enterDepth();

            int pivotIndex = SortUtils.partition(arr, low, high, metrics);

            if (pivotIndex - low < high - pivotIndex) {
                quickSort(arr, low, pivotIndex - 1, metrics);
                low = pivotIndex + 1;
            } else {
                quickSort(arr, pivotIndex + 1, high, metrics);
                high = pivotIndex - 1;
            }

            metrics.exitDepth();
        }
    }
}

package com.company.sorts.quicksort;

import com.company.metrics.Metrics;

import java.util.Random;

public class QuickSortRandomPivot {
    private static final Random rand = new Random();

    public static void sort(int[] arr, Metrics metrics) {
        quickSort(arr, 0, arr.length - 1, metrics);
    }

    private static void quickSort(int[] arr, int low, int high, Metrics metrics) {
        if (low < high) {
            metrics.incrementRecursiveCalls();
            metrics.enterDepth();

            int pivotIndex = partition(arr, low, high, metrics);
            quickSort(arr, low, pivotIndex - 1, metrics);
            quickSort(arr, pivotIndex + 1, high, metrics);

            metrics.exitDepth();
        }
    }

    private static int partition(int[] arr, int low, int high, Metrics metrics) {
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        swap(arr, pivotIndex, high, metrics);
        int pivot = arr[high];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            metrics.incrementComparisons();
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j, metrics);
            }
        }
        swap(arr, i + 1, high, metrics);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j, Metrics metrics) {
        if (i != j) {
            metrics.incrementSwaps();
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

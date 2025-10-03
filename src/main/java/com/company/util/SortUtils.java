package com.company.util;

import com.company.metrics.Metrics;
import java.util.Random;

public class SortUtils {
    private static final Random rand = new Random();

    public static int partition(int[] arr, int low, int high, Metrics metrics) {
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        swap(arr, pivotIndex, high);

        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            metrics.incrementComparisons();
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    public static boolean validRange(int low, int high) {
        return low < high;
    }
}

package com.company.sorts.mergesort;

import com.company.metrics.Metrics;

public class MergeSortBuffer {

    public static void sort(int[] arr, Metrics metrics) {
        if (arr == null || arr.length <= 1) return;
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1, metrics);
    }

    private static void mergeSort(int[] arr, int[] aux, int low, int high, Metrics metrics) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        mergeSort(arr, aux, low, mid, metrics);
        mergeSort(arr, aux, mid + 1, high, metrics);
        merge(arr, aux, low, mid, high, metrics);
    }

    private static void merge(int[] arr, int[] aux, int low, int mid, int high, Metrics metrics) {
        System.arraycopy(arr, low, aux, low, high - low + 1);

        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            metrics.incrementComparisons();
            if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }
        while (i <= mid) arr[k++] = aux[i++];
        while (j <= high) arr[k++] = aux[j++];
    }
}

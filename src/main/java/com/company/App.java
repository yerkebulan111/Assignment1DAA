package com.company;

import com.company.metrics.Metrics;
import com.company.metrics.CsvWriter;

import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        CsvWriter csvWriter = new CsvWriter("results.csv");

        int[] array = generateRandomArray(10000);

        // Example: Bubble Sort
        metrics.reset();
        bubbleSort(Arrays.copyOf(array, array.length), metrics);
        csvWriter.writeMetrics("BubbleSort", metrics);

        System.out.println("Finished. Metrics saved to results.csv");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(100);
        return arr;
    }

    // Bubble sort
    private static void bubbleSort(int[] arr, Metrics metrics) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                metrics.incrementComparisons();
                if (arr[j] > arr[j + 1]) {
                    metrics.incrementSwaps();
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

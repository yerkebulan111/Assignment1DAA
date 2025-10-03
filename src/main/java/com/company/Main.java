package com.company;

import com.company.metrics.*;
import com.company.sorts.mergesort.*;
import com.company.sorts.quicksort.*;
import com.company.sorts.deterministicselect.DeterministicSelect;
import com.company.sorts.closest.ClosestPair;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = 10_000;
        int trials = 1;
        String algo = "";
        int rnd = 42;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--size": size = Integer.parseInt(args[++i]); break;
                case "--trials": trials = Integer.parseInt(args[++i]); break;
                case "--algo": algo = args[++i].toLowerCase(); break;
                case "--rnd": rnd = Integer.parseInt(args[++i]); break;
            }
        }

        Random random = new Random(rnd);
        Metrics metrics = new Metrics();
        CsvWriter csvWriter = new CsvWriter("results.csv");

        if (algo.equals("allsorts")) {
            runMergeSortBaseline(size, trials, random, metrics, csvWriter);
            runMergeSortBuffer(size, trials, random, metrics, csvWriter);
            runMergeSortCutoff(size, trials, random, metrics, csvWriter);
            runQuickSortRandom(size, trials, random, metrics, csvWriter);
            runQuickSortSmall(size, trials, random, metrics, csvWriter);
            runDeterministicSelect(size, trials, random, metrics, csvWriter);
            runClosestPair(size, trials, random, metrics, csvWriter);
        } else if (algo.equals("mergesort-base")) {
            runMergeSortBaseline(size, trials, random, metrics, csvWriter);
        } else if (algo.equals("mergesort-buffer")) {
            runMergeSortBuffer(size, trials, random, metrics, csvWriter);
        } else if (algo.equals("mergesort-cutoff")) {
            runMergeSortCutoff(size, trials, random, metrics, csvWriter);
        } else if (algo.equals("quicksort-rand")) {
            runQuickSortRandom(size, trials, random, metrics, csvWriter);
        } else if (algo.equals("quicksort-small")) {
            runQuickSortSmall(size, trials, random, metrics, csvWriter);
        } else if (algo.equals("deterministic-select")) {
            runDeterministicSelect(size, trials, random, metrics, csvWriter);
        } else if (algo.equals("closest-pair")) {
            runClosestPair(size, trials, random, metrics, csvWriter);
        } else {
            System.err.println("Unknown algorithm: " + algo);
        }

        System.out.println("Finished. Results written to results.csv");
    }


    private static int[] generateRandomArray(int size, Random random) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = random.nextInt(1_000_000);
        return arr;
    }

    private static ClosestPair.Point[] generateRandomPoints(int size, Random random) {
        ClosestPair.Point[] points = new ClosestPair.Point[size];
        for (int i = 0; i < size; i++) {
            points[i] = new ClosestPair.Point(random.nextInt(10_000), random.nextInt(10_000));
        }
        return points;
    }

    private static void runMergeSortBaseline(int size, int trials, Random random, Metrics metrics, CsvWriter csv) {
        for (int t = 1; t <= trials; t++) {
            metrics.reset();
            int[] array = generateRandomArray(size, random);
            long start = System.nanoTime();
            MergeSortBaseline.sort(array, metrics);
            long time = System.nanoTime() - start;
            csv.writeMetrics("MergeSortBaseline", size, t, time, metrics, 0);
        }
    }

    private static void runMergeSortBuffer(int size, int trials, Random random, Metrics metrics, CsvWriter csv) {
        for (int t = 1; t <= trials; t++) {
            metrics.reset();
            int[] array = generateRandomArray(size, random);
            long start = System.nanoTime();
            MergeSortBuffer.sort(array, metrics);
            long time = System.nanoTime() - start;
            csv.writeMetrics("MergeSortBuffer", size, t, time, metrics, 0);
        }
    }

    private static void runMergeSortCutoff(int size, int trials, Random random, Metrics metrics, CsvWriter csv) {
        for (int t = 1; t <= trials; t++) {
            metrics.reset();
            int[] array = generateRandomArray(size, random);
            long start = System.nanoTime();
            MergeSortCutOff.sort(array, metrics);
            long time = System.nanoTime() - start;
            csv.writeMetrics("MergeSortCutoff", size, t, time, metrics, 0);
        }
    }

    private static void runQuickSortRandom(int size, int trials, Random random, Metrics metrics, CsvWriter csv) {
        for (int t = 1; t <= trials; t++) {
            metrics.reset();
            int[] array = generateRandomArray(size, random);
            long start = System.nanoTime();
            QuickSortRandomPivot.sort(array, metrics);
            long time = System.nanoTime() - start;
            csv.writeMetrics("QuickSortRandomPivot", size, t, time, metrics, 0);
        }
    }

    private static void runQuickSortSmall(int size, int trials, Random random, Metrics metrics, CsvWriter csv) {
        for (int t = 1; t <= trials; t++) {
            metrics.reset();
            int[] array = generateRandomArray(size, random);
            long start = System.nanoTime();
            QuickSortSmallerFirst.sort(array, metrics);
            long time = System.nanoTime() - start;
            csv.writeMetrics("QuickSortSmallerFirst", size, t, time, metrics, 0);
        }
    }

    private static void runDeterministicSelect(int size, int trials, Random random, Metrics metrics, CsvWriter csv) {
        for (int t = 1; t <= trials; t++) {
            metrics.reset();
            int[] array = generateRandomArray(size, random);
            long start = System.nanoTime();
            DeterministicSelect.select(array, size / 2);
            long time = System.nanoTime() - start;
            csv.writeMetrics("DeterministicSelect", size, t, time, metrics, 0);
        }
    }

    private static void runClosestPair(int size, int trials, Random random, Metrics metrics, CsvWriter csv) {
        for (int t = 1; t <= trials; t++) {
            metrics.reset();
            ClosestPair.Point[] points = generateRandomPoints(size, random);
            long start = System.nanoTime();
            ClosestPair.findClosest(points);
            long time = System.nanoTime() - start;
            csv.writeMetrics("ClosestPair", size, t, time, metrics, 0);
        }
    }
}

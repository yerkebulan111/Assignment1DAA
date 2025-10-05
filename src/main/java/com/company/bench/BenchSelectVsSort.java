package com.company.bench;

import com.company.sorts.deterministicselect.DeterministicSelect;
import com.company.sorts.mergesort.MergeSortBaseline;
import com.company.sorts.quicksort.QuickSortRandomPivot;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class BenchSelectVsSort {

    @Param({"1000", "10000", "50000"})
    private int size;

    private int[] data;
    private Random rand;

    @Setup(Level.Invocation)
    public void setup() {
        rand = new Random(42);
        data = rand.ints(size, 0, 1_000_000).toArray();
    }

    @Benchmark
    public int testDeterministicSelect() {
        int[] copy = Arrays.copyOf(data, data.length);
        return DeterministicSelect.select(copy, size / 2);
    }

    @Benchmark
    public int[] testQuickSort() {
        int[] copy = Arrays.copyOf(data, data.length);
        QuickSortRandomPivot.sort(copy, null);
        return copy;
    }

    @Benchmark
    public int[] testMergeSort() {
        int[] copy = Arrays.copyOf(data, data.length);
        MergeSortBaseline.sort(copy, null);
        return copy;
    }
}

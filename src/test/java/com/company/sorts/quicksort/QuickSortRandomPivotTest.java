package com.company.sorts.quicksort;

import com.company.metrics.Metrics;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickSortRandomPivotTest {

    @Test
    void testRandomArray() {
        Random rand = new Random();
        int[] arr = rand.ints(10_000, 0, 100_000).toArray();
        int[] copy = Arrays.copyOf(arr, arr.length);

        Metrics metrics = new Metrics();
        QuickSortRandomPivot.sort(arr, metrics);

        Arrays.sort(copy);
        assertTrue(Arrays.equals(arr, copy));
    }
}

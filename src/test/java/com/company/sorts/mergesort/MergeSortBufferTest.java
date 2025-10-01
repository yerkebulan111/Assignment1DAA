package com.company.sorts.mergesort;

import com.company.metrics.Metrics;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortBufferTest {

    @Test
    void testRandomArray() {
        Random rand = new Random();
        int[] arr = rand.ints(10_000, 0, 100_000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);

        Metrics metrics = new Metrics();
        MergeSortBuffer.sort(arr, metrics);

        assertArrayEquals(expected, arr);
    }
}

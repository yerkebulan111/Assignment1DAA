package com.company.sorts.deterministicselect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {

    @Test
    void testSmallArray() {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        assertEquals(1, DeterministicSelect.select(arr.clone(), 0)); // smallest
        assertEquals(8, DeterministicSelect.select(arr.clone(), 7)); // largest
    }

    @Test
    void testMedianOdd() {
        int[] arr = {10, 50, 20, 40, 30};
        assertEquals(30, DeterministicSelect.select(arr.clone(), 2)); // median
    }

    @Test
    void testMedianEven() {
        int[] arr = {8, 4, 2, 6};
        assertEquals(4, DeterministicSelect.select(arr.clone(), 1));
        assertEquals(6, DeterministicSelect.select(arr.clone(), 2));
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        assertEquals(42, DeterministicSelect.select(arr.clone(), 0));
    }

    @Test
    void testInvalidK() {
        int[] arr = {1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> DeterministicSelect.select(arr, -1));
        assertThrows(IllegalArgumentException.class, () -> DeterministicSelect.select(arr, 3));
    }
}

package com.company.sorts.closest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {

    @Test
    void testSmallSet() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4),
                new ClosestPair.Point(7, 7),
                new ClosestPair.Point(1, 1)
        };
        double d = ClosestPair.findClosest(points);
        assertEquals(Math.sqrt(2), d, 1e-6);
    }

    @Test
    void testTwoPoints() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(5, 0)
        };
        double d = ClosestPair.findClosest(points);
        assertEquals(5.0, d, 1e-6);
    }
}

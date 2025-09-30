package com.company.metrics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetricsTest {

    @Test
    public void testComparisonsIncrement() {
        Metrics metrics = new Metrics();
        metrics.incrementComparisons();
        metrics.incrementComparisons();
        assertEquals(2, metrics.getComparisons());
    }

    @Test
    public void testSwapsIncrement() {
        Metrics metrics = new Metrics();
        metrics.incrementSwaps();
        assertEquals(1, metrics.getSwaps());
    }

    @Test
    public void testDepthTracking() {
        Metrics metrics = new Metrics();
        metrics.enterDepth();
        metrics.enterDepth();
        metrics.exitDepth();
        assertEquals(2, metrics.getMaxDepth());
        assertEquals(1, metrics.getComparisons()); // may be wrong, I will change later
    }

    @Test
    public void testReset() {
        Metrics metrics = new Metrics();
        metrics.incrementComparisons();
        metrics.reset();
        assertEquals(0, metrics.getComparisons());
    }
}

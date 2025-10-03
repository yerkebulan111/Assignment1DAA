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
    public void testAllocationsIncrement() {
        Metrics metrics = new Metrics();
        metrics.incrementAllocations();
        metrics.incrementAllocations();
        assertEquals(2, metrics.getAllocations());
    }

    @Test
    public void testDepthTracking() {
        Metrics metrics = new Metrics();
        metrics.enterDepth();
        metrics.enterDepth();
        metrics.exitDepth();
        assertEquals(2, metrics.getMaxDepth());
    }

    @Test
    public void testReset() {
        Metrics metrics = new Metrics();
        metrics.incrementComparisons();
        metrics.incrementAllocations();
        metrics.enterDepth();
        metrics.reset();
        assertEquals(0, metrics.getComparisons());
        assertEquals(0, metrics.getAllocations());
        assertEquals(0, metrics.getMaxDepth());
    }
}

package com.company.metrics;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private String filePath;

    public CsvWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeMetrics(String algorithm, Metrics metrics) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(algorithm).append(",")
                    .append(String.valueOf(metrics.getComparisons())).append(",")
                    .append(String.valueOf(metrics.getSwaps())).append(",")
                    .append(String.valueOf(metrics.getRecursiveCalls())).append(",")
                    .append(String.valueOf(metrics.getMaxDepth()))
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

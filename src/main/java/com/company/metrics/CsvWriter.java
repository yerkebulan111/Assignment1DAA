package com.company.metrics;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private final String filePath;

    public CsvWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeMetrics(String algorithm, int n, int trial, long timeNs, Metrics metrics, long allocations) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(algorithm).append(",")
                    .append(String.valueOf(n)).append(",")
                    .append(String.valueOf(trial)).append(",")
                    .append(String.valueOf(timeNs)).append(",")
                    .append(String.valueOf(metrics.getMaxDepth())).append(",")
                    .append(String.valueOf(metrics.getComparisons())).append(",")
                    .append(String.valueOf(allocations))
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

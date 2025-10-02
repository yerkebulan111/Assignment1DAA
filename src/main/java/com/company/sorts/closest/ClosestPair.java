package com.company.sorts.closest;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {


    public static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    private static double distance(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }


    public static double findClosest(Point[] points) {
        Point[] sortedByX = points.clone();
        Arrays.sort(sortedByX, Comparator.comparingInt(p -> p.x));
        return closestUtil(sortedByX, 0, sortedByX.length - 1);
    }


    private static double closestUtil(Point[] points, int left, int right) {
        if (right - left <= 3) {
            double min = Double.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    min = Math.min(min, distance(points[i], points[j]));
                }
            }
            return min;
        }

        int mid = (left + right) / 2;
        double dl = closestUtil(points, left, mid);
        double dr = closestUtil(points, mid + 1, right);
        double d = Math.min(dl, dr);

        int midX = points[mid].x;


        Point[] strip = new Point[right - left + 1];
        int stripSize = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midX) < d) {
                strip[stripSize++] = points[i];
            }
        }

        Arrays.sort(strip, 0, stripSize, Comparator.comparingInt(p -> p.y));


        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (strip[j].y - strip[i].y) < d; j++) {
                d = Math.min(d, distance(strip[i], strip[j]));
            }
        }

        return d;
    }
}

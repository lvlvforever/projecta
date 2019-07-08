package io.algorithm.thirdweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvlvforever
 * @createTime 2019-02-09 10:25
 * @description
 */
public class BruteCollinearPoints {
    private Point[] points;
    private List<LineSegment> lineSegments = new ArrayList<>();

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("points must not be null");
        }
        for (Point point : points) {
            if (point == null) {
                throw new IllegalArgumentException("point must not be null");
            }
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("same points not allowed");
                }
            }
        }
        this.points = points;

        int n = this.points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        Point startPoint = this.points[i];
                        double slope1 = startPoint.slopeTo(this.points[j]);
                        double slope2 = startPoint.slopeTo(this.points[k]);
                        double slope3 = startPoint.slopeTo(this.points[l]);
                        if (slope1 == slope2 && slope1 == slope3) {
                            Point[] segment = new Point[]{startPoint, this.points[j], this.points[k], this.points[l]};
                            Arrays.sort(segment);
                            lineSegments.add(new LineSegment(segment[0], segment[3]));
                        }
                    }
                }
            }
        }


    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }
}

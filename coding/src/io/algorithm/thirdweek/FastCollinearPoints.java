package io.algorithm.thirdweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvlvforever
 * @createTime 2019-02-10 08:34
 * @description
 */
public class FastCollinearPoints {
    private Point[] points;
    private List<LineSegment> lineSegments = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {

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

        for (Point point : points) {
            Arrays.sort(this.points);
            Arrays.sort(this.points, point.slopeOrder());

            int start = 1;
            int curTotal = 1;
            for (int i = 2; i < this.points.length; i++) {
                if (point.slopeTo(this.points[start]) == point.slopeTo(this.points[i])) {
                    curTotal++;
                }
                if (curTotal >= 4) {


                }
            }


        }


    }

    public int numberOfSegments() {
        return 0;
    }

    public LineSegment[] segments() {
        return null;
    }

    private boolean judgeSameOne(NestedLineSegment o1, NestedLineSegment o2) {


    }

    private class NestedLineSegment {


    }
}

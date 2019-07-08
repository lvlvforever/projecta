package io.algorithm.thirdweek;

/**
 * @author lvlvforever
 * @createTime 2019-02-09 11:05
 * @description
 */
public class TestBrute {
    public static void main(String[] args) {

        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        Point d = new Point(4, 4);
        Point e = new Point(5, 1);
        Point[] arr = new Point[]{a, b, c, d, e};
        BruteCollinearPoints brute = new BruteCollinearPoints(arr);
        System.err.println(brute.numberOfSegments());
        LineSegment[] segments = brute.segments();
        System.err.println(brute.segments());


    }
}

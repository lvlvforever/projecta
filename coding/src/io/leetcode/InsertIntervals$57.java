package io.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvlvforever on 2019/1/20.
 */
public class InsertIntervals$57 {
    public static void main(String[] args) {

    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        if (newInterval == null) {
            return intervals;
        }
        int n = intervals.size();
        int i = 0;
        while (i < n && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }
        while (i < n && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals.get(i));
            i++;
        }
        return result;

    }


}



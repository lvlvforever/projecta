package io.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lvlvforever on 2019/1/21.
 */
public class MergeIntevals$56 {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        Interval one = new Interval(1, 4);
        Interval two = new Interval(0, 2);
        Interval three = new Interval(3, 5);
        input.add(one);
        input.add(two);
        input.add(three);
        MergeIntevals$56 obj = new MergeIntevals$56();
        System.err.println(obj.merge(input));


    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }
        List<Interval> result = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }

        });

        int i = 0;
        while (i < intervals.size()) {
            Interval cur = intervals.get(i);
            if (i != intervals.size() - 1) {
                Interval next = intervals.get(i + 1);
                if (cur.end >= next.start) {
                    cur.start = Math.min(cur.start, next.start);
                    cur.end = Math.max(cur.end, next.end);
                    intervals.remove(i + 1);
                } else {
                    result.add(cur);
                    i++;
                }

            } else {
                i++;
                result.add(cur);
            }

        }


        return result;
    }
}

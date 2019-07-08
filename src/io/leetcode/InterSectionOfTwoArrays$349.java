package io.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvlvforever on 2019/1/17.
 */
public class InterSectionOfTwoArrays$349 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return null;
        }
        Map<Integer, Boolean> nums1Map = new HashMap<>();
        Map<Integer, Boolean> nums2Map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1Map.put(nums1[i], true);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2Map.put(nums2[i], true);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer value : nums2Map.keySet()) {
            if (nums1Map.containsKey(value)) {
                result.add(value);
            }
        }
        int[] v = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            v[i] = result.get(i);
        }
        return v;


    }

    public int[] intersection2(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return null;
        }
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer value = nums1Map.get(nums1[i]);
            if (value == null) {
                value = 0;
            }
            value++;
            nums1Map.put(nums1[i], value);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {

            Integer value = nums1Map.get(nums2[i]);
            if (value != null && value > 0) {
                value--;
                nums1Map.put(nums2[i], value);
                result.add(nums2[i]);
            }

        }

        int[] v = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            v[i] = result.get(i);
        }
        return v;


    }

}

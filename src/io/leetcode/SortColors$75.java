package io.leetcode;

import io.util.Utils;

import java.util.Arrays;

/**
 * Created by lvlvforever on 2019/1/25.
 */
public class SortColors$75 {
    public static void main(String[] args) {
        SortColors$75 obj = new SortColors$75();
        int[] nums = {0, 1, 1, 0, 2};
        obj.sortColors(nums);
        System.err.println(Arrays.toString(nums));

    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int k = 0;
        while (k < n && k <= j) {

            int value = nums[k];
            if (value == 0) {
                Utils.swap(nums, k, i);
                k++;
                i++;
            } else if (value == 1) {
                k++;
            } else if (value == 2) {

                Utils.swap(nums, k, j);
                j--;
            }

        }


    }


}

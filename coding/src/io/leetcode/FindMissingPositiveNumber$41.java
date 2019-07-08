package io.leetcode;

import java.util.BitSet;

/**
 * @author lvlvforever
 * @createTime 2018-12-30 15:17
 * @description
 */
public class FindMissingPositiveNumber$41 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        FindMissingPositiveNumber$41 obj = new FindMissingPositiveNumber$41();

        System.err.println(obj.firstMissingPositive2(nums));
    }


    public int firstMissingPositive(int[] nums) {
        BitSet set = new BitSet(2);
        if (nums == null || nums.length < 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                set.set(nums[i] - 1, true);
            }
        }
        for (int i = 0; i < set.length(); i++) {
            if (!set.get(i)) {
                return i + 1;
            }
        }
        return set.length() + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

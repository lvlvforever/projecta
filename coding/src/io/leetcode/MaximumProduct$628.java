package io.leetcode;

import java.util.Arrays;

/**
 * Created by lvlvforever on 2018/12/23.
 */
public class MaximumProduct$628 {
    public static void main(String[] args) {
        MaximumProduct$628 obj = new MaximumProduct$628();
        int[] b = {-8, 2, 1, 4};
        System.err.println(obj.maximumProduct(b));

    }

    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }


        int count = nums.length;

        Arrays.sort(nums);

        int cadidate1 = nums[count - 1] * nums[count - 2] * nums[count - 3];
        int cadidate2 = nums[count - 1] * nums[0] * nums[1];
        return cadidate1 > cadidate2 ? cadidate1 : cadidate2;

    }


}

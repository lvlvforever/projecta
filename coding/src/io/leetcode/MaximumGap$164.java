package io.leetcode;

/**
 * Created by lvlvforever on 2019/1/23.
 */
public class MaximumGap$164 {
    public static void main(String[] args) {

        MaximumGap$164 obj = new MaximumGap$164();
        int[] nums = {2, 99999999};
        System.err.println(obj.maximumGap(nums));
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int digits = queryMaxDigits(nums);

        int[] count = new int[10];
        int n = nums.length;
        int[] tmp = new int[n];
        int divide = 1;
        for (int i = 0; i <= digits; i++) {
            for (int j = 0; j < 10; j++) {
                count[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                tmp[j] = nums[j];
            }
            for (int j = 0; j < n; j++) {
                int t = (nums[j] / divide) % 10;
                count[t]++;
            }
            for (int j = 1; j < 10; j++) {
                count[j] = count[j] + count[j - 1];
            }
            for (int j = n - 1; j >= 0; j--) {
                int t = (nums[j] / divide) % 10;
                int index = count[t] - 1;
                count[t]--;
                tmp[index] = nums[j];
            }
            for (int j = 0; j < n; j++) {
                nums[j] = tmp[j];
            }
            divide = divide * 10;
        }


        return findGap(nums);




    }

    private int findGap(int[] nums) {
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int g = nums[i] - nums[i - 1];
            if (g > gap) {
                gap = g;
            }
        }
        return gap;


    }

    private int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    private int queryMaxDigits(int[] nums) {
        int max = findMax(nums);
        int digits = 0;
        while (max != 0) {
            max = (max / 10);
            digits++;
        }
        return digits;
    }
}

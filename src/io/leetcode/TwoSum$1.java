/**
 * Description:
 * User: daipeng
 * Date: 2018-12-20 9:54
 * Project:SolutionForCodingInterview
 */
package io.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum$1 {
    public static void main(String[] args) {


    }
    public int[] twoSum(int[] nums, int target) {
        int[] value = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(target == nums[i] + nums[j]){
                    value[0] = i;
                    value[1] = j;
                    return value;
                }
            }
        }
        return value;

    }
    public int[] twoSum1(int[] nums, int target) {
        int[] value = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
             if(map.containsKey(target - nums[i])){
                 value[0] = map.get(target - nums[i]);
                 value[1] = i;
                 return value;
             }else{
                 map.put(nums[i], i);
             }
        }
        return value;

    }
}

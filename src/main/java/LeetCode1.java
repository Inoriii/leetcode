package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sakura
 */
public class LeetCode1 {
    //
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(32);
        int targetNum;
        for (int i = 0; i < nums.length; i++) {
            targetNum = target - nums[i];
            Integer integer = map.get(targetNum);
            if (integer == null) {
                map.put(nums[i], i);
                continue;
            }
            return new int[]{integer, i};
        }
        return null;
    }
}
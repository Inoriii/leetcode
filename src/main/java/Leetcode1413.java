package main.java;

/**
 * @author sakura
 */
public class Leetcode1413 {
    public int minStartValue(int[] nums) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            int temp = sum + nums[i];
            if (temp >= 1) {
                sum = temp;
            } else {
                sum = 1;
                ans += 1 - temp;
            }
        }
        return ans == 0 ? 1 : ans;
    }
}
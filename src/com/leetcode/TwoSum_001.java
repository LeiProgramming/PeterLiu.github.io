package com.leetcode;

/**
 * @author Peter
 */
public class TwoSum_001 {
    public static void main(String[] args) {


    }
}

/**
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i ; j--) {
                if (nums[i] + nums[j] == target){
                    res = new int[]{i, j};
                }
            }
        }
        return res;
    }
}
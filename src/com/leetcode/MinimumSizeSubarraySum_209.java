package com.leetcode;

/**
 * @author Peter
 */
class MinimumSizeSubarraySum {
    public static void main(String[] args) {

    }
}

/**
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class daySolution01 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target){
                int subLength = (right - left + 1);
                res = res < subLength ? res : subLength;
                sum -= nums[left ++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;

    }
}
package com.leetcode;

import java.util.HashSet;

/**
 * @author Peter
 */
public class BinarySearch_704 {
    class Solution{
        public int search(int[] nums, int target){
            int left = 0;
            int right = nums.length - 1;

            while (left <= right){
                int mid = left + (right - left) >> 1;
                if (target == nums[mid]){
                    return mid;
                }
                else if (target > nums[mid]){
                    left = mid + 1;
                }
                else
                    right = mid - 1;
            }
            return -1;
        }
    }
}

/**
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */



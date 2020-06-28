package com.jesse.leetcode.左右指针滑动窗口.长度最小的子数组;

/**
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * @author jesse hsj
 * @date 2020/6/28 14:16
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new Solution().minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0,right = 0;
        int sum = 0;

        int start = 0,end = 0;
        int length = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum += nums[right];
            right ++;
            while(sum >= s) {
                if (right - left < length) {
                    start = left;
                    end = right;
                    length = right - left;
                }
                sum -= nums[left];
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? 0:length;
    }
}

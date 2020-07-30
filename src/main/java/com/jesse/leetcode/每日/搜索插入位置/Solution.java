package com.jesse.leetcode.每日.搜索插入位置;

/**
 * @author jesse hsj
 * @date 2020/7/17
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(new Solution().searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right-left)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid-1;
            else
                left = mid+1;
        }

        if (nums[mid] < target) {
            mid++;
        }

        return mid;
    }
}

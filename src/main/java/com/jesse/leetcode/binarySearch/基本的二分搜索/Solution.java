package com.jesse.leetcode.binarySearch.基本的二分搜索;

/**
 * 基本的二分搜索
 *
 * @author jesse hsj
 * @date 2020/6/20
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3};
        int target = 2;

        System.out.println(new Solution().search(nums, target));
    }



    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


}

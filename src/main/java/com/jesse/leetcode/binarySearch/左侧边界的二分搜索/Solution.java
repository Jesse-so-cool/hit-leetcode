package com.jesse.leetcode.binarySearch.左侧边界的二分搜索;

/**
 * @author jesse hsj
 * @date 2020/6/20
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3};
        int target = 2;

        System.out.println(new Solution().search(nums, target));
    }

    //左侧第一个
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

    //使用闭区间
    public int search2(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1; // 注意

        //当left = right + 1 会跳出循环
        while (left <= right) { // 注意
            int mid = left + (left - right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1; // 注意
            }
        }

        //检查出界情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
}

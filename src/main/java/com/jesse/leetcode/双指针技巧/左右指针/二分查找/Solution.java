package com.jesse.leetcode.双指针技巧.左右指针.二分查找;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2021/3/5 10:24
 */
public class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

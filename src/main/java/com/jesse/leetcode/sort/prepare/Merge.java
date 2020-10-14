package com.jesse.leetcode.sort.prepare;

import com.jesse.leetcode.sort.Sort;

import java.util.Arrays;

/**
 * @author jesse hsj
 * @date 2020/10/14
 */
public class Merge implements Sort {
    @Override
    public void sort(int[] nums) {
        sort(nums,0,nums.length);
    }

    private void sort(int[] nums, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low)/2;
        sort(nums,low,mid);
        sort(nums,mid+1,high);

        merge(nums,low,mid,high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int left = low;
        int right = mid + 1;

        while (left <= high) {
            //if ()
        }


    }
}

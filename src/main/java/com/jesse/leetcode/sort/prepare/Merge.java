package com.jesse.leetcode.sort.prepare;

import com.google.gson.Gson;
import com.jesse.leetcode.sort.Sort;

import java.util.Arrays;

/**
 * @author jesse hsj
 * @date 2020/10/14
 */
public class Merge implements Sort {

    public static void main(String[] args) {
        int nums[] = {2, 1, 7, 9, 5, 8};
        new com.jesse.leetcode.sort.Merge().sort(nums);
        System.out.println(new Gson().toJson(nums));
    }


    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length);
    }

    private void sort(int[] nums, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int left = low;
        int right = mid + 1;

        for (int i = low; i <= high; i++) {
            if (left > mid) {
                nums[i] = copy[right++];
                continue;
            }
            if (right > high) {
                nums[i] = copy[left++];
                continue;
            }

            if (copy[left] <= copy[right]) {
                nums[i] = copy[left];
                left++;
            } else if (copy[left] > copy[right]) {
                nums[i] = copy[right];
                right++;
            }
        }

    }
}

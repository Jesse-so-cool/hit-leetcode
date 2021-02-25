package com.jesse.leetcode.sort.prepare;

import com.google.gson.Gson;
import com.jesse.leetcode.sort.Sort;

import java.util.Arrays;

/**
 * @author jesse hsj
 * @date 2020/12/1
 */
public class Merge2 implements Sort {

    public static void main(String[] args) {
        int[] nums = {54,21,73,84,60,18,62,59,89,89,41,55,27,65,94,61,12,76,35,48,0,60,84,9,28,55,4,67,86,33};
        new Merge2().sort(nums);
        System.out.println(new Gson().toJson(nums));
    }

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] copy = Arrays.copyOf(nums, nums.length);

        int left1 = low;
        int left2 = mid+1;
        for (int i = low; i <= high; i++) {

            if (left1 > mid){
                break;//突然意识到这里直接break掉就可以了
            }
            if (left2 > high){
                nums[i] = copy[left1++];
                continue;
            }

            if (copy[left1] <= copy[left2]) {
                nums[i] = copy[left1 ++];
            }else {
                nums[i] = copy[left2 ++];
            }

        }
    }
}
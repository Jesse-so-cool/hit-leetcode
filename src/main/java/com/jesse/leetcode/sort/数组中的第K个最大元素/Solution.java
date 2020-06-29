package com.jesse.leetcode.sort.数组中的第K个最大元素;


import java.util.Random;

/**
 * 利用快排的特性
 *
 * @author jesse hsj
 * @date 2020/6/29 15:53
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 5;
        System.out.println(new Solution().findKthLargest(nums, k));
    }

    int k;

    //时间复杂度O(N)
    private int findKthLargest(int[] nums, int k) {
        this.k = nums.length - k;
        return sort(nums, 0, nums.length - 1);

    }

    //快排中
    //这个base值被算出来后 是不会再换位置的
    //利用这个特性 可以做一些需要特定下标的题目
    //int base = partition(nums,low,high);
    private int sort(int[] nums, int low, int high) {
        int base = partition(nums, low, high);
        if (base == k) return nums[k];
        else
            return base < k ? sort(nums, base+1, high) : sort(nums, low-1, base);

    }

    private int partition(int[] nums, int low, int high) {
        int random = new Random().nextInt(high - low) + low;
        swap(nums, random, high);

        int index = low;

        for (int i = low; i < high; i++) {
            if (nums[i] < nums[high]) {
                swap(nums,i,index++);
            }
        }

        swap(nums,index,high);

        return index;
    }

    private void swap(int[] nums, int random, int high) {
        int temp = nums[high];
        nums[high] = nums[random];
        nums[random] = temp;
    }
}

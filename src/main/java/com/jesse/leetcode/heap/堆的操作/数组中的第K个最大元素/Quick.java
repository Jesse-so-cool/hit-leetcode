package com.jesse.leetcode.heap.堆的操作.数组中的第K个最大元素;

import java.util.Random;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2021/3/15 13:26
 */
public class Quick {

    public static void main(String[] args) {
        int[] nums = {-1,2,0};
        int k = 2;
        System.out.println(new Quick().findKthLargest(nums, k));
    }

    /**
     * 快排思想解决
     * 时间复杂度O(N) 不是O(NlgN)
     */
    private int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums,k,0,nums.length-1);
    }
    private int findKthLargest(int[] nums, int k, int low, int high) {
        int partition = partition(nums,low,high);
        if (partition == (nums.length-k)){
            return nums[partition];
        }else if (partition < nums.length-k){
            return findKthLargest(nums,k,partition+1,high);
        }else {
            return findKthLargest(nums,k,low,partition);
        }
    }

    private int partition(int[] nums, int low, int high) {
        if (low == high)
            return low;
        int random = new Random().nextInt(high-low) + low;
        swap(nums,random,high);
        int k = low;
        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[high]){
                swap(nums,i,k);
                k++;
            }
        }
        swap(nums,k,high);

        return k;
    }

    private void swap(int[] nums, int random, int high) {
        int temp = nums[high];
        nums[high] = nums[random];
        nums[random] = temp;
    }

}

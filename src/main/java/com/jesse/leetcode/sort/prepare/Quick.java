package com.jesse.leetcode.sort.prepare;

import com.google.gson.Gson;
import com.jesse.leetcode.sort.Sort;

import java.util.Random;

/**
 * @author jesse hsj
 * @date 2020/10/15
 */
public class Quick implements Sort {

    public static void main(String[] args) {
        int nums[] = {54,21,73,84,60,18,62,59,89,89,41,55,27,65,94,61,12,76,35,48,0,60,84,9,28,55,4,67,86,33};
        new com.jesse.leetcode.sort.Quick().sort(nums);
        System.out.println(new Gson().toJson(nums));
    }

    @Override
    public void sort(int[] nums) {

        sort(nums,0,nums.length-1);

    }
    //小 随机 大 小 随机 大 小 随机 大  小 随机 大
    private void sort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int partition = partition(nums,low,high);
        sort(nums,low,partition);
        sort(nums,partition+1,high);
    }

    //找出临时值 使左边得值小于它，右边得大于它
    private int partition(int[] nums, int low, int high) {
        int random = low + new Random().nextInt(high - low);
        swap(nums,random,high);

        //维护一个会走动的索引
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]){
                swap(nums,i++,j);
            }
        }

        swap(nums,random,high);
        return i;
    }

    private void swap(int[] nums, int random, int high) {
        int temp = nums[high];
        nums[high] = nums[random];
        nums[random] = temp;
    }
}

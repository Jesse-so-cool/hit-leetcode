package com.jesse.leetcode.sort.prepare;

import com.google.gson.Gson;
import com.jesse.leetcode.sort.Sort;

import java.util.Random;

/**
 * @author jesse hsj
 * @date 2020/12/1
 */
public class Quick2 implements Sort {

    public static void main(String[] args) {
        int[] nums = {0,0,2,3,2,1,1,2,0,4};
        new Quick2().sort(nums);
        System.out.println(new Gson().toJson(nums));
    }

    @Override
    public void sort(int[] nums) {
        sort(nums,0,nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int partition = getPartition(nums,low,high);
        sort(nums,low,partition);
        sort(nums,partition + 1,high);
    }

    private int getPartition(int[] nums, int low, int high) {
        int random = low + new Random().nextInt(high - low);
        swap(nums,random,high);

        //基准值
        int base = nums[high];
        //设置一个值，循环完毕后，partition 指针之前的数都比基准值小,之后的大于等于基准值
        int partition = low;

        for (int i = low; i < high; i++) {
            if (nums[i] < base){
                swap(nums,partition++,i);
            }
        }

        swap(nums,partition,high);

        return partition;
    }

    private void swap(int[] nums, int random, int high) {
        int temp = nums[high];
        nums[high] = nums[random];
        nums[random] = temp;
    }
}

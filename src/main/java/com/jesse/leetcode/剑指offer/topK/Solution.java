package com.jesse.leetcode.剑指offer.topK;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jesse hsj
 * @date 2020/12/20
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,0,2,3,2,1,1,2,0,4};
        System.out.println(new Gson().toJson(new Solution().getLeastNumbers(nums, 10)));
    }
    int k = 0;
    //快速选择
    public int[] getLeastNumbers(int[] arr, int k) {
        this.k = k;
        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int low, int high) {

        int index = partition(arr,low,high);
        if (index == k-1) {
            return Arrays.copyOf(arr, index);
        }
        quickSort(arr,low,index-1);
        quickSort(arr,index+1,high);
        return new int[0];
    }

    private int partition(int[] nums, int low, int high) {
        System.out.println(high - low);
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

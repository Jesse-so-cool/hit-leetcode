package com.jesse.leetcode.sort;

import com.google.gson.Gson;

/**
 * 插入
 *
 * @author jesse hsj
 * @date 2020/6/10 15:29
 */
public class Insertion implements Sort {
    public static void main(String[] args) {
        int nums[] = {6,2,4,1,3,5};
        new Insertion().sort(nums);
        System.out.println(new Gson().toJson(nums));
    }

    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j]<nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }else {
                    System.out.println();
                    break;
                }
            }
        }
    }
}

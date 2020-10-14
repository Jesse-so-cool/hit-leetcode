package com.jesse.leetcode.sort.prepare;

import com.google.gson.Gson;
import com.jesse.leetcode.sort.Sort;

/**
 * @author jesse hsj
 * @date 2020/10/14
 */
public class Bubble implements Sort {
    public static void main(String[] args) {
        int nums[] = {54,21,73,84,60,18,62,59,89,89,41,55,27,65,94,61,12,76,35,48,0,60,84,9,28,55,4,67,86,33};
        int nums2[] = {0,4,9,12,18,21,27,28,33,35,41,48,54,55,55,59,60,60,61,62,65,67,73,76,84,84,86,89,89,94};
        new com.jesse.leetcode.sort.Bubble().sort(nums2);
        System.out.println(new Gson().toJson(nums2));
    }

    @Override
    public void sort(int[] nums) {
        boolean isSwap = true;//如果没被交换过，说明本身就是顺序的

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[j+1]){
                    swap(nums,j,j+1);
                    isSwap = false;
                }
            }
            if (isSwap) {
                break;
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


}

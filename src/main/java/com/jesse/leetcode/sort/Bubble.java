package com.jesse.leetcode.sort;

import com.google.gson.Gson;

/**
 * 冒泡
 *
 *空间复杂度：
 *  只用了temp，所以空间复杂度是 O(1)。
 *时间复杂度
 *  1. 给定的数组按照顺序已经排好
 *      在这种情况下，我们只需要进行 n−1 次的比较，两两交换次数为 0，时间复杂度是 O(n)。这是最好的情况。
 *  2. 给定的数组按照逆序排列
 *      在这种情况下，我们需要进行 n(n-1)/2 次比较，时间复杂度是 O(n^2)。这是最坏的情况。
 *  3. 给定的数组杂乱无章
 *      在这种情况下，平均时间复杂度是 O(n^2)。
 *
 * @author jesse hsj
 * @date 2020/6/10 14:55
 */
public class Bubble implements Sort {

    public static void main(String[] args) {
        int nums[] = {54,21,73,84,60,18,62,59,89,89,41,55,27,65,94,61,12,76,35,48,0,60,84,9,28,55,4,67,86,33};
        new Bubble().sort(nums);
        System.out.println(new Gson().toJson(nums));
    }

    @Override
    public void sort(int[] nums) {
        boolean isSort = true;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isSort = false;
                }
            }

            if (isSort) {
                break;
            }

        }
    }
}

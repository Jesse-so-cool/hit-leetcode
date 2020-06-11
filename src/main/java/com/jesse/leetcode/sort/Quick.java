package com.jesse.leetcode.sort;

import com.google.gson.Gson;

import java.util.Random;

/**
 * 快速
 *      快速排序也采用了分治的思想，使用基准去分左右两边数组
 *
 *时间复杂度
 *
 *  1. 最优情况：被选出来的基准值都是当前子数组的中间数。
 *          这样的分割，能保证对于一个规模大小为 n 的问题，能被均匀分解成两个规模大小为 n/2 的子问题（归并排序也采用了相同的划分方法），时间复杂度就是：T(n) = 2×T(n/2) + O(n)。
 *          把规模大小为 n 的问题分解成 n/2 的两个子问题时，和基准值进行了 n-1 次比较，复杂度就是 O(n)。很显然，在最优情况下，快速排序的复杂度也是 O(nlogn)。
 *  2. 最坏情况：基准值选择了子数组里的最大或者最小值
 *      每次都把子数组分成了两个更小的子数组，其中一个的长度为 1，另外一个的长度只比原子数组少 1。
 *      举例：对于数组来说，每次挑选的基准值分别是 9、8、7、5、2。
 *      解法：划分过程和冒泡排序的过程类似。
 *      算法复杂度为 O(n2)。
 * @author jesse hsj
 * @date 2020/6/11 14:17
 */
public class Quick implements Sort{

    public static void main(String[] args) {
        int nums[] = {2, 1, 7, 9, 5, 8};
        new Quick().sort(nums);
        System.out.println(new Gson().toJson(nums));
    }


    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {

        if (low >= high ) return;

        int base = partition(nums,low,high);

        sort(nums,low,base);
        sort(nums,base+1,high);

    }

    private int partition(int[] nums, int low, int high) {

        final int random = new Random().nextInt(high-low) + low;
        //现在最后一位是我们选中的基准值
        swap(nums,random,high);

        //从左到右用每个数和基准值比较，若比基准值小，则放到指针 i 所指向的位置。循环完毕后，i 指针之前的数都比基准值小
        int i = low;

        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums,i++,j);
            }
        }

        swap(nums,i,high);
        return i;
    }

    private void swap(int[] nums, int random, int high) {
        int temp = nums[high];
        nums[high] = nums[random];
        nums[random] = temp;
    }
}

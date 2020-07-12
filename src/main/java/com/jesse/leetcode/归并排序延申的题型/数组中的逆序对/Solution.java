package com.jesse.leetcode.归并排序延申的题型.数组中的逆序对;

/**
 * 要求统计逆序数，还要用具有“稳定性”的排序算法才能正确地统计，
 *      稳定性是指相同元素在排序后相对位置保持不变，不稳定的排序算法可能会把[1,1]的逆序度当成1。
 * @author jesse hsj
 * @date 2020/7/11
 */
public class Solution {

    public static void main(String[] args) {
        int nums[] = {7,5,6,4};
        long start = System.currentTimeMillis();
        System.out.println(new Solution().reversePairs(nums));
        System.out.println(System.currentTimeMillis()-start);
    }

    int count = 0;

    public int reversePairs(int[] nums) {
        //辅助数组
        int[] copy = new int[nums.length];
        sort(nums,0,nums.length-1,copy);
        return count;
    }

    //借助归并排序统计逆序数
    private void sort(int[] nums, int low, int high, int[] copy) {
        if (low >= high) return ;

        int mid = low + (high-low)/2;
        sort(nums,low,mid, copy);
        sort(nums,mid+1,high, copy);
        if (nums[mid] <= nums[mid + 1]) {
            return ;
        }
        merge(nums,low,mid,high,copy);
    }
    //计算逆序数就发生在排序的过程中，利用了「排序」以后数组的有序性
    private void merge(int[] nums, int low, int mid, int high, int[] temp) {
        //int count = 0;
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        int left = low;
        int right = mid + 1;
        for (int i = low; i <= high; i++) {
            if (right > high) {
                nums[i] = temp[left++];
                continue;
            }
            if (left > mid) {
                nums[i] = temp[right++];
                continue;
            }
            if (temp[left] > temp[right]) {
                nums[i] = temp[right++];
                count += mid-left+1;//在右边的子区间元素归并回去的时候，计算逆序对的个数（其实也可以用左边，但是只能用一边）
            }else if (temp[left] <= temp[right]){
                nums[i] = temp[left++];
            }
        }
        //return count;
    }

}

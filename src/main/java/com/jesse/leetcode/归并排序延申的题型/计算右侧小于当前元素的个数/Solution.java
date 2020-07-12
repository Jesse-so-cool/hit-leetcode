package com.jesse.leetcode.归并排序延申的题型.计算右侧小于当前元素的个数;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jesse hsj
 * @date 2020/7/11
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(new Gson().toJson(new Solution().countSmaller(nums)));
    }

    int[] counts;
    int[] temp;
    int[] indexes;
    public List<Integer> countSmaller(int[] nums) {
        counts = new int[nums.length];
        //辅助数组
        temp = new int[nums.length];
        //辅助索引数组
        indexes = new int[nums.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        sort(nums,0,nums.length-1);

        return Arrays.stream(counts).boxed().collect(Collectors.toList());
    }

    //借助归并排序统计逆序数
    private void sort(int[] nums, int low, int high) {
        if (low >= high) return ;

        int mid = low + (high-low)/2;
        sort(nums,low,mid);
        sort(nums,mid+1,high);

        //小优化
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
            return;
        }
        merge(nums,low,mid,high);
    }
    //计算逆序数就发生在排序的过程中，利用了「排序」以后数组的有序性
    private void merge(int[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = indexes[i];
        }
        int left = low;
        int right = mid + 1;
        for (int i = low; i <= high; i++) {
            if (right > high) {
                indexes[i] = temp[left++];
                counts[indexes[i]] += high-mid;
                continue;
            }
            if (left > mid) {
                indexes[i] = temp[right++];
                continue;
            }
            if (nums[temp[left]] > nums[temp[right]]) {
                indexes[i] = temp[right++];
            }else if (nums[temp[left]] <= nums[temp[right]]){
                indexes[i] = temp[left++];//在左边的子区间元素归并回去的时候，计算逆序对的个数（
                counts[indexes[i]] += right-mid-1;
            }
        }
    }
}

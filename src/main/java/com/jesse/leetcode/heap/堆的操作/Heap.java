package com.jesse.leetcode.heap.堆的操作;

import com.google.gson.Gson;
import com.jesse.leetcode.heap.堆的操作.数组中的第K个最大元素.Solution;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2020/6/29 9:24
 */
@SuppressWarnings("ALL")
public class Heap {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        //int k = 1;
        new Heap().buildMinHeap(nums);
        System.out.println(new Gson().toJson(nums));
    }

    //从倒数第一个非叶子节点开始，到root
    public void buildMaxHeap(int[] nums) {
        int length = nums.length;
        for (int i = length/2; i > 0 ; i--) {
            maxHeapify(nums,i,length);
        }
    }

    public void buildMinHeap(int[] nums) {
        int length = nums.length;
        for (int i = length/2; i >= 0 ; i--) {
            minHeapify(nums,i,length);
        }
        System.out.println();
    }

    private void minHeapify(int[] nums, int i, int length) {
        int l = 2*i+1;
        int r = 2*i+2;
        int min = i;
        if (l<length && nums[l] < nums[min]) {
            min = l;
        }
        if (r<length && nums[r] < nums[min]) {
            min = r;
        }
        if (min != i) {
            swap(nums,i,min);
            minHeapify(nums,min,length);
        }

    }

    //对堆开始最大堆化
    private void maxHeapify(int[] nums, int i, int length) {
        int l = 2*i+1;
        int r = 2*i+2;
        int max = i;
        if (l<length && nums[l] > nums[max]) {
            max = l;
        }
        if (r<length && nums[r] > nums[max]) {
            max = r;
        }
        if (max != i) {
            swap(nums,i,max);
            maxHeapify(nums,max,length);
        }
    }

    //堆中每次都只能删除第0个数据
    private void deleteMax(int[] nums) {
        swap(nums,0,nums.length-1);
        maxHeapify(nums,0,nums.length-1);
    }


    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

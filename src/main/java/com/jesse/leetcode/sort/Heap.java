package com.jesse.leetcode.sort;

import com.google.gson.Gson;

/**
 * 堆排序
 *
 * @author jesse hsj
 * @date 2020/6/29 10:56
 */
@SuppressWarnings("ALL")
public class Heap implements Sort{

    public static void main(String[] args) {
        int nums[] = {2,4,1,3,5};
        new Heap().sort(nums);
        System.out.println(new Gson().toJson(nums));
    }

    //从小到大用最大堆
    //时间复杂度是建堆时间O(n)+O(nlogn)
    @Override
    public void sort(int[] nums) {

        buildMaxHeap(nums);

        for (int i = nums.length-1; i >= 0; i--) {
            swap(nums,0,i);
            maxHeapify(nums,0,i);
        }


    }
    public void sort2(int[] nums) {

        buildMinHeap(nums);

        for (int i = nums.length-1; i > 0; i--) {
            swap(nums,0,i);
            minHeapify(nums,0,i);
        }


    }

    //从倒数第一个非叶子节点开始，到root
    //o(n) 时间复杂度
    public void buildMaxHeap(int[] nums) {
        int length = nums.length;
        for (int i = length/2; i >= 0 ; i--) {
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
    //堆调整的时间复杂度是O(log n)
    private void maxHeapify(int[] nums, int i, int length) {
        //节点k的左、右子节点为2k+1和2k+2。
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

package com.jesse.leetcode.heap.堆的操作.数组中的第K个最大元素;

/**
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * @author jesse hsj
 * @date 2020/6/29 10:12
 */
@SuppressWarnings("ALL")
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(new Solution().findKthLargest(nums, k));
    }
    //堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
    // 将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
    //  这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
    //我们根据堆排序的思想，在反复执行到第k+1个时，nums[0]就是答案了
    public int findKthLargest(int[] nums, int k) {
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, i);
        }
        return nums[0];
    }

    //从倒数第一个非叶子节点开始，到root
    public void buildMaxHeap(int[] nums) {
        int length = nums.length;
        for (int i = length/2; i >= 0 ; i--) {
            maxHeapify(nums,i,length);
        }
    }

    //对堆开始堆化
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

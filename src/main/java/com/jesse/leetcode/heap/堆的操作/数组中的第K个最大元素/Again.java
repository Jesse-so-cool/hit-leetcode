package com.jesse.leetcode.heap.堆的操作.数组中的第K个最大元素;

import java.util.PriorityQueue;

/**
 * 可以尝试
 *
 * @author jesse hsj
 * @date 2021/3/15 10:24
 */
public class Again {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(new Again().findKthLargest(nums, k));
    }

    private int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (heap.size() < k){
                heap.add(num);
            }else {
                if (num > heap.peek()) {
                   heap.poll();
                   heap.add(num);
                }
            }
        }
        return heap.peek();

    }

}

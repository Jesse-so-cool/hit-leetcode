package com.jesse.leetcode.heap.中位数;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 无序数组的中位数
 * 从题目发现要找出中间的两个数或者一个数
 *
 * @author jesse hsj
 * @date 2021/3/15 9:57
 */
public class Again2 {


    public static void main(String[] args) {
        int[] nums = {5,1,3,4};
        Again2 again2 = new Again2();
        System.out.println(again2.mid(nums));

    }

    public double mid(int[] nums) {
        MedianFinder medianFinder = new MedianFinder();
        for (int i = 0; i < nums.length; i++) {
            medianFinder.addNum(nums[i]);
        }
        return medianFinder.findMedian();
    }

    class MedianFinder {
        /**
         * 最小堆和最大堆
         * 最大堆存小的值
         * 最小堆存较大的值
         */
        Queue<Integer> maxHeap = null;
        Queue<Integer> minHeap = null;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minHeap = new PriorityQueue<>();
        }

        /**
         * 放入比最小堆都小的数
         * @param num
         */
        void addNum(int num) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
        }

        double findMedian() {
            if (maxHeap.size() == minHeap.size()){
                return (double)(minHeap.peek() + maxHeap.peek())/2;
            }
            return maxHeap.size();
        }
    }
}

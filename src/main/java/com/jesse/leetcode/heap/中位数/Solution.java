package com.jesse.leetcode.heap.中位数;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 *
 * @author jesse hsj
 * @date 2020/6/24 17:01
 */
public class Solution {

    class MedianFinder {
        /**
         * 最小堆和最大堆
         *  最大堆存小的值
         *  最小堆存较大的值
         */
        Queue<Integer> maxHeap = null;
        Queue<Integer> minHeap = null;
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
            minHeap = new PriorityQueue<>();
        }
        void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return (double)maxHeap.peek();
            }
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }
    }


}

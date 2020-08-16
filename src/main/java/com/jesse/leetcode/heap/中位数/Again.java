package com.jesse.leetcode.heap.中位数;

import java.util.PriorityQueue;

/**
 * @author jesse hsj
 * @date 2020/8/16
 */
public class Again {


    class MedianFinder {
        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;
        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            max = new PriorityQueue<>((x, y) -> (y - x));
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            min.offer(num);
            max.offer(min.poll());
            if (max.size() > min.size()) {
                min.offer(max.poll());
            }
        }

        public double findMedian() {
            if (min.size() == max.size())
                return (double) (min.peek() + max.peek()) / 2;
            return min.peek();
        }

        public void remove(int num) {
            if (min.remove(num)) {
                if (max.size() > min.size()) {
                    min.offer(max.poll());
                }
                return;
            }
            max.remove(num);
        }
    }

}

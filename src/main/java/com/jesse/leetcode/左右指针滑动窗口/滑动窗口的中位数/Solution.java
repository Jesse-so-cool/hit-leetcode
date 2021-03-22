package com.jesse.leetcode.左右指针滑动窗口.滑动窗口的中位数;

import com.google.gson.Gson;

import java.util.PriorityQueue;

/**
 * @author jesse hsj
 * @date 2020/8/16
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648};

        System.out.println(new Gson().toJson(new Solution().medianSlidingWindow(nums, 2)));
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < k) {
            return new double[]{};
        }
        double[] res = new double[len - k + 1];

        MedianFinder medianFinder = new MedianFinder();
        for (int i = 0; i < len; i++) {
            if (i < k - 1) {
                medianFinder.addNum(nums[i]);
            } else {
                medianFinder.addNum(nums[i]);
                res[i - k + 1] = medianFinder.findMedian();
                medianFinder.remove(nums[i - k + 1]);
            }
        }
        return res;
    }

    class MedianFinder {
        PriorityQueue<Long> max;
        PriorityQueue<Long> min;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            max = new PriorityQueue<>((x, y) -> Long.compare(y, x));
            min = new PriorityQueue<>();
        }

        public void addNum(long num) {
            min.offer(num);
            max.offer(min.poll());
            if (max.size() > min.size()) {
                min.offer(max.poll());
            }
        }

        public double findMedian() {
            if (min.size() == max.size())
                return (max.peek() + (min.peek() - max.peek()) / 2.0);
            return min.peek();
        }

        public void remove(long num) {
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

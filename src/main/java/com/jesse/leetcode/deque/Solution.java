package com.jesse.leetcode.deque;

import com.google.gson.Gson;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author jesse hsj
 * @date 2020/8/13 11:47
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        System.out.println(new Gson().toJson(new Solution().maxSlidingWindow(nums, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < k) {
            return new int[]{};
        }
        MyDeque myDeque = new MyDeque();
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            int num = nums[i];

            if (i < k - 1) {
                myDeque.offer(num);
            } else {
                myDeque.offer(num);
                res[i - k + 1] = myDeque.deque.peek();
                int num1 = nums[i - k + 1];
                myDeque.pop(num1);
            }
        }
        return res;
    }

    class MyDeque {
        Deque<Integer> deque = new LinkedList<>();

        void pop(int val) {
            if (!deque.isEmpty() && deque.peek() == val) {
                deque.pop();
            }
        }

        void offer(int val) {
            while (!deque.isEmpty() && deque.peekLast() < val) {
                deque.removeLast();
            }
            deque.offer(val);
        }
    }

}

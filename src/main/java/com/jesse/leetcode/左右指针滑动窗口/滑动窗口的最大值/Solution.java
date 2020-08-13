package com.jesse.leetcode.左右指针滑动窗口.滑动窗口的最大值;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;
import com.sun.org.apache.bcel.internal.generic.I2F;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jesse hsj
 * @date 2020/8/13 11:47
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
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

            if (i < k) {
                myDeque.push(num);
            } else {
                res[i - k] = myDeque.deque.peek();
                myDeque.push(num);
                myDeque.pop(nums[i - k]);
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

        void push(int val) {
            while (!deque.isEmpty() && deque.peekLast() < val) {
                deque.pop();
            }
            deque.push(val);
        }
    }

}

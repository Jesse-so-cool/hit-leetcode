package com.jesse.leetcode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 单调双端队列
 *
 * @author jesse hsj
 * @date 2020/6/8 10:05
 */
public class MonotonicDeque {

    Deque<Integer> deque = new ArrayDeque<>();

    /**
     * 单调队列的 push 方法依然在队尾添加元素，但是要把前面比新元素小的元素都删掉
     * @param data
     */
    public void push(int data) {
        while (!deque.isEmpty() && deque.peek() < data) {
            deque.pop();
        }

        deque.push(data);
    }

    public int max() {
        return deque.peekLast();
    }

    void pop(int n) {
        if (!deque.isEmpty() && deque.peek() == n)
            deque.pop();
    }

}

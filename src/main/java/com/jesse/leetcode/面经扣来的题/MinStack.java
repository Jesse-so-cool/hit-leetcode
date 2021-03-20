package com.jesse.leetcode.面经扣来的题;

import java.util.LinkedList;

/**
 * @author jesse hsj
 * @date 2021/3/20
 */
public class MinStack {


    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(val < minStack.peek() ? val : minStack.peek());
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}

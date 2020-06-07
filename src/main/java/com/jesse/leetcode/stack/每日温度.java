package com.jesse.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @descrition 根据每日温度列表，生成一个列表是你需要等待多少天才能升温的天数，如果之后不升高，为0
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * @author jesse hsj
 * @date 2020/6/7
 */
public class 每日温度 {

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Stack<Integer> stack = new Stack();
        int[] days = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
                days[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        Arrays.stream(days).forEach(System.out::println);
    }

}

package com.jesse.leetcode.stack;

import java.util.Stack;

/**
 * @author jesse hsj
 * @date 2020/6/7
 */
public class 有效的括号 {

    public static void main(String[] args) {
        String a = "{([])}}";

        boolean isValid = isValid(a);

        System.out.println(isValid);
    }

    private static boolean isValid(String s) {
        if (s.length()%2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '{' || charAt == '(' || charAt == '[') {
                stack.push(charAt);
            } else if (charAt == '}' || charAt == ')' || charAt == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop == '{' && charAt != '}') {
                    return false;
                }
                if (pop == '[' && charAt != ']') {
                    return false;
                }
                if (pop == '(' && charAt != ')') {
                    return false;
                }

            }
        }
        return stack.empty();
    }

}

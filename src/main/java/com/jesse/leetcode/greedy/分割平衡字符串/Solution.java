package com.jesse.leetcode.greedy.分割平衡字符串;

import java.util.Stack;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2020/7/2 15:21
 */
public class Solution {

    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int k = 0;
        for (char c : chars) {
            if (c == 'R') {
                k += 1;
            }else if(c == 'L'){
                k -= 1;
            }

            if (k == 0) {
                res ++;
            }
        }
        return res;
    }

}

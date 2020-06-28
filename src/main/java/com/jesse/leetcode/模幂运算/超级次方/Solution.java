package com.jesse.leetcode.模幂运算.超级次方;

import java.util.LinkedList;

public class Solution {

    int mod = 1337;

    public int superPow(int a, int[] b) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int bb : b) {
            list.add(bb);
        }
        return superPow(a, list);
    }

    private int superPow(int a, LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return 1;
        }
        Integer integer = list.peekLast();
        list.pollLast();
        int part1 = mypow(a, integer);
        int part2 = mypow(superPow(a, list), 10);
        return (part1 * part2) % mod;
    }

    //计算某个数的n次方
    private int mypow(int a, int k) {
        a = a % mod;
        int result = 1;

        for (int i = 0; i < k; i++) {
            result = (result * a) % mod;
        }
        return result;
    }
}

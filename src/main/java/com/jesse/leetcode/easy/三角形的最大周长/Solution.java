package com.jesse.leetcode.easy.三角形的最大周长;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *
 * @author jesse hsj
 * @date 2020/7/9 9:13
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {1,2,1};
        System.out.println(new Solution().largestPerimeter(a));
    }

    public int largestPerimeter(int[] A) {
        if (A.length < 3)
            return 0;
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2 ; i--) {
            if (A[i-1]+A[i-2] > A[i]) {
                return A[i-1]+A[i-2]+A[i];
            }
        }
        return 0;
    }
}

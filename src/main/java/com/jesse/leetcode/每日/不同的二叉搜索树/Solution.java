package com.jesse.leetcode.每日.不同的二叉搜索树;

/**
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author jesse hsj
 * @date 2020/7/15
 */
public class Solution {

    int[][] temp ;
    public int numTrees(int n) {
        temp = new int[n+1][n+1];
        return helper(1,n);
    }

    private int helper(int low, int high) {
        if (temp[low][high] != 0)
            return temp[low][high];
        int res = 0;
        if (low >= high)
            return 1;
        for (int i = low; i <= high ; i++) {
            int left = helper(low,i-1);
            int right = helper(low+1,high);
            res += left*right;
        }
        temp[low][high] = res;
        return res;
    }

}

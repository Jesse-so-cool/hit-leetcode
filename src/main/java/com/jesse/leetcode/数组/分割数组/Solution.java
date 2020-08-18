package com.jesse.leetcode.数组.分割数组;

import com.google.gson.Gson;

/**
 * @author jesse hsj
 * @date 2020/8/18
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,6,-1,12};
        System.out.println(new Gson().toJson(new Solution().partitionDisjoint(nums)));
    }

    public int partitionDisjoint(int[] A) {
        Integer prevMax = A[0];

        int index = 0;
        boolean findMax = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < prevMax) {
                if (findMax) {
                    index = i;
                } else {
                    prevMax = getMax(index, i, A, prevMax);
                    findMax = true;
                    index = i;
                }
            } else if (A[i] >= prevMax) {
                if (findMax) {
                    findMax = false;
                }
            }

        }
        return index + 1;
    }

    private int getMax(int start, int i, int[] A, Integer prevMax) {
        int max = prevMax;
        for (int i1 = start; i1 <= i; i1++) {
            max = Integer.max(max, A[i1]);
        }
        return max;
    }
}

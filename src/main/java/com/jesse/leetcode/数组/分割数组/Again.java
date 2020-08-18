package com.jesse.leetcode.数组.分割数组;

import com.google.gson.Gson;

/**
 * @author jesse hsj
 * @date 2020/8/18
 */
public class Again {

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,6,-1,12};
        System.out.println(new Gson().toJson(new Again().partitionDisjoint(nums)));
    }

    public int partitionDisjoint(int[] A) {
        int max = A[0];
        int leftMax = A[0];
        int pos = 0;
        for (int i = 1; i < A.length; i++) {
            max = Integer.max(max,A[i]);
            if (A[i] >= leftMax)
                continue;
            leftMax = max;
            pos = i;
        }
        return pos+1;
    }
}

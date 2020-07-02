package com.jesse.leetcode.greedy.非递增顺序的最小子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2020/7/2 11:58
 */
public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        List<Integer> ls = new ArrayList<>();
        int subSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ls.add(nums[i]);
            subSum += nums[i];
            sum -= nums[i];
            if (subSum > sum)
                return ls;
        }
        return null;
    }

}

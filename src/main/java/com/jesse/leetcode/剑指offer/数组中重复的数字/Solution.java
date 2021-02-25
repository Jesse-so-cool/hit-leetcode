package com.jesse.leetcode.剑指offer.数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jesse hsj
 * @date 2020/12/6
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            if(set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }
}

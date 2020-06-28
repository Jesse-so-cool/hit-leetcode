package com.jesse.leetcode.双指针技巧.左右指针.有序数组两数之和;

/**
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author jesse hsj
 * @date 2020/6/22 16:09
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left,right};
            }else if (sum > target) {
                right--;
            }else if (sum < target) {
                left++;
            }
        }
        return null;
    }

}

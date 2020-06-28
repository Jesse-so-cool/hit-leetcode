package com.jesse.leetcode.数组.缺失的第一个正数;

import java.util.Arrays;

/**
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }

    //问题在于 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
    //所以我们只能用原本的nums来作为我们使用的主要空间
    public int firstMissingPositive(int[] nums) {
        //正常的哈希表需要额外的O(N)空间
        //但是我们可以设计一个hashcode() 让我们原来的nums得到使用
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[hashCode(nums[i])] != nums[i]) {
                swap(nums, hashCode(nums[i]), i);
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;

    }

    private void swap(int[] nums, int hashCode, int i) {
        int temp = nums[hashCode];
        nums[hashCode] = nums[i];
        nums[i] = temp;
    }

    private int hashCode(int num) {
        return num - 1;
    }

}

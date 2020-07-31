package com.jesse.leetcode.每日.两数之和;

import com.google.gson.Gson;

import java.util.Arrays;

/**
 * @author jesse hsj
 * @date 2020/7/17
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        System.out.println(new Gson().toJson(new Solution().twoSum(nums, 10)));
    }

    public int[] twoSum(int[] nums, int target) {
        int temp[] = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            if (nums[left]+nums[right] == target) {
                break;
            }else if (nums[left]+nums[right] < target) {
                left++;
            }else {
                right--;
            }
        }

        if (left >= right) {
            return new int[]{};
        }
        int res[] = new int[2];
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == nums[left] || temp[i] == nums[right]) {
                res[k++] = i;
            }
        }
        return res;

    }
}

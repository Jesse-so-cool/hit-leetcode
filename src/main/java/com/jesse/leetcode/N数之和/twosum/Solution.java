package com.jesse.leetcode.N数之和.twosum;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * nums 中可能有多对儿元素之和都等于 target，请你的算法返回所有和为 target 的元素对儿，其中不能出现重复
 *
 * 基本思路肯定还是排序加双指针
 * @author jesse hsj
 * @date 2020/7/17
 */
public class Solution {
    public static void main(String[] args) {
            int[] nums = {1,1,1,2,2,3,3};
            System.out.println(new Gson().toJson(new Solution().twoSum(nums,4)));
    }
    public List<List<Integer>> twoSum(int[] nums,int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int left = 0,right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int low = nums[left];
            int high = nums[right];
            if (sum > target)
                while (left < right && nums[right] == high) right--;
            else if (sum < target)
                while (left < right && nums[left] == low) left++;
            else {
                res.add(Arrays.asList(nums[left],nums[right]));
                while (left < right && nums[right] == high) right--;
                while (left < right && nums[left] == low) left++;
            }
        }
        return res;
    }
}

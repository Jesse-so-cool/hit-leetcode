package com.jesse.leetcode.N数之和.threesum;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基本思路肯定还是排序加双指针
 * @author jesse hsj
 * @date 2020/7/17
 */
public class Solution {
    public static void main(String[] args) {
            int[] nums = {-1, 0, 1, 2, -1, -4};
            System.out.println(new Gson().toJson(new Solution().threeSum(nums,0)));
    }
    public List<List<Integer>> threeSum(int[] nums,int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> twoSum = twoSum(nums, i+1, target-num);
            for (int j = 0; j < twoSum.size(); j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.addAll(twoSum.get(j));
                res.add(temp);
            }
            while (i < nums.length-1 && num == nums[i+1]) {
                i++;
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums,int left, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int right = nums.length-1;
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

package com.jesse.leetcode.N数之和.nsum;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/7/17
 */
@SuppressWarnings("ALL")
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        Arrays.sort(nums);
        System.out.println(new Gson().toJson(new Solution().nSumTarget(nums, 4, 0, 0)));
    }

    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int sz = nums.length;
        if (n < 2 || sz < n) return res;

        if (n == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int low = nums[left];
                int high = nums[right];
                if (sum > target)
                    while (left < right && nums[right] == high) right--;
                else if (sum < target)
                    while (left < right && nums[left] == low) left++;
                else {
                    res.add(Arrays.asList(nums[left], nums[right]));
                    while (left < right && nums[right] == high) right--;
                    while (left < right && nums[left] == low) left++;
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                int num = nums[i];
                List<List<Integer>> twoSum = nSumTarget(nums, n - 1, i + 1, target - num);
                for (int j = 0; j < twoSum.size(); j++) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(twoSum.get(j));
                    res.add(temp);
                }
                while (i < nums.length - 1 && num == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

}



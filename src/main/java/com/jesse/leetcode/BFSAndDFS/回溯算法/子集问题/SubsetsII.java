package com.jesse.leetcode.BFSAndDFS.回溯算法.子集问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/6/20
 */
public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        SubsetsII subsets = new SubsetsII();
        System.out.println(subsets.subsetsWithDup(nums));
    }

    List<List<Integer>> results = new ArrayList<>();

    //和普通不重复的相比，我们可以先排序
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int startIndex = 0;
        Arrays.sort(nums);
        List<Integer> track = new ArrayList<>();
        backtrack(nums,startIndex,track);
        return results;
    }

    private void backtrack(int[] nums, int startIndex, List<Integer> track) {
        results.add(new ArrayList<>(track));

        for (int i = startIndex; i < nums.length; i++) {
            if (i >0 && nums[i] == nums[i-1] && i != startIndex) {
                continue;
            }

            track.add(nums[i]);
            backtrack(nums,i+1, track);
            track.remove(track.size()-1);
        }
    }
}

package com.jesse.leetcode.BFSAndDFS.回溯算法.全排列问题;

import com.google.gson.Gson;

import java.util.*;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2021/3/22 15:38
 */
public class Solution {

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(new Gson().toJson(new Solution().permute(nums)));
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> re = new LinkedList<>();
        dfs(re,nums);
        return res;

    }

    private void dfs(LinkedList<Integer> re, int[] nums) {
        if (re.size() == nums.length){
            res.add(new LinkedList<>(re));
            return;
        }
        for (int integer : nums) {
            if (re.contains(integer)){
                continue;
            }
            re.add(integer);
            dfs(re,nums);
            re.removeLast();
        }
    }

}

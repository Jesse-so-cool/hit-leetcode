package com.jesse.leetcode.二叉搜索树.二叉搜索树中的众数;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/7/26
 */
public class Solution {

        public static void main(String[] args) {
                Integer[] nums = {1,2,null,2};
                System.out.println(new Gson().toJson(new Solution().findMode(TreeNode.create(nums))));
        }
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};

        List<Integer> res = new ArrayList<>();
        int curTimes = 1, maxTimes = 0;

        midOrder(root, null, curTimes, maxTimes, res);

        int[] re = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            re[i] = res.get(i);
        }
        return re;
    }
    private void midOrder(TreeNode root, TreeNode pre, int curTimes, int maxTimes, List<Integer> res) {
        if (root == null)
            return;
        midOrder(root.left, pre, curTimes, maxTimes, res);
        if (pre!=null && pre.val == root.val) {
            curTimes++;
            if (maxTimes < curTimes) {
                res.clear();
                maxTimes = curTimes;
                res.add(root.val);
            } else if (maxTimes == curTimes) {
                res.add(root.val);
            }
        } else {
            curTimes = 1;
        }
        pre = root;
        midOrder(root.right, pre, curTimes, maxTimes, res);
    }
}

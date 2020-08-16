package com.jesse.leetcode.tree.二叉树中第二小的节点;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/8/2
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1};
        System.out.println(new Gson().toJson(new Solution().findSecondMinimumValue(TreeNode.create(nums))));
    }

    public int findSecondMinimumValue(TreeNode root) {
        int help = helper(root,root.val);
        return help;
    }

    private int helper(TreeNode x,int rootValue) {
        if(x.val != rootValue) // 如果当前结点不等于根结点至，那么当x值为以x为根的最小的非rootValue的值
            return x.val;
        // 这之下都是 当前结点值为根结点值的情况
        if(x.left == null) // 递归到叶子结点 且其值为根结点值，说明没有找到第二小的值，返回失败标志-1。
            return -1;
        int leftMin = helper(x.left, rootValue);
        int rightMin = helper(x.right, rootValue);
        if(leftMin == -1)
            return rightMin;
        if(rightMin == -1)
            return leftMin;
        return Math.min(leftMin, rightMin);
    }
}

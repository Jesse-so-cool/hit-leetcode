package com.jesse.leetcode.tree.根据二叉树创建字符串;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/8/1
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4};
        System.out.println(new Gson().toJson(new Solution().tree2str(TreeNode.create(nums))));
    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        dfs(t, sb);
        return sb.toString();
    }

    private void dfs(TreeNode t, StringBuilder sb) {
        if (t == null) return;
        sb.append(t.val);
        if (t.right == t.left && t.left == null)
            return;
        if (t.right == null) {
            sb.append("(");
            dfs(t.left, sb);
            sb.append(")");
            return;
        }
        sb.append("(");
        dfs(t.left, sb);
        sb.append(")");

        sb.append("(");
        dfs(t.right, sb);
        sb.append(")");
    }
}

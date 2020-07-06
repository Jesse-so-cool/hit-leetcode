package com.jesse.leetcode.二叉搜索树.验证二叉搜索树;

import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/7/5
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{-2147483648,-2147483648};
        System.out.println(new Solution().isValidBST(TreeNode.create(a)));
    }

    long min = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (root.val <= min)
            return false;
        min = root.val;
        return isValidBST(root.right);
    }
}

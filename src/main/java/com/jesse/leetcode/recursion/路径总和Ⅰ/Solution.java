package com.jesse.leetcode.recursion.路径总和Ⅰ;

import com.jesse.leetcode.entity.TreeNode;

/**
 *
 * @author jesse hsj
 * @date 2020/7/7 9:42
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] integers = {-2,null,-3};
        System.out.println(new Solution().hasPathSum(TreeNode.create(integers), -5));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;
            if (sum-root.val == 0 && root.left == null && root.right == null)
                return true;

            return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}

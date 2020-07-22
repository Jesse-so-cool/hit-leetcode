package com.jesse.leetcode.tree.二叉树的深度;

import com.jesse.leetcode.entity.TreeNode;

/**
 *
 * @author jesse hsj
 * @date 2020/7/22 10:15
 */
public class Solution {

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        return Integer.max(maxDepth(root.left),maxDepth(root.right))+1;

    }

}

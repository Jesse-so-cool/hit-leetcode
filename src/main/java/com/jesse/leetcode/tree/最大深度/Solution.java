package com.jesse.leetcode.tree.最大深度;

import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/7/19
 */
public class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        return 1 + Integer.max(maxDepth(root.left),maxDepth(root.right));

    }
}

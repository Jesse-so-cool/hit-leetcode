package com.jesse.leetcode.tree.平衡二叉树;

import com.jesse.leetcode.entity.TreeNode;

/**
 * IsBalanced
 *
 * @author jesse hsj
 * @date 2020/7/7 11:49
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return Math.abs(height(root.left)-height(root.right))<2 && isBalanced(root.left) && isBalanced(root.right);

    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

}

package com.jesse.leetcode.tree.对称二叉树;

import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/7/16
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);

    }


    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
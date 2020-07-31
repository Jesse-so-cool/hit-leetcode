package com.jesse.leetcode.二叉搜索树.二叉搜索树中第K小的元素;

import com.jesse.leetcode.entity.TreeNode;

/**
 * 递归
 *
 * @author jesse hsj
 * @date 2020/7/23 10:52
 */
public class Solution {
    int res = 0,k=0;

    private void midOrder(TreeNode root) {
        if (root == null || k==0) {
            return;
        }
        midOrder(root.left);
        if (--k == 0) {
            res = root.val;
            return;
        }
        midOrder(root.right);


    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        midOrder(root);
        return res;
    }
}

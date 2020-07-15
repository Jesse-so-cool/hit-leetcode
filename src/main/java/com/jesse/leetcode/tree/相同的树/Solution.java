package com.jesse.leetcode.tree.相同的树;

import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/7/15
 */
public class Solution {


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(q.right,p.right);
    }
}

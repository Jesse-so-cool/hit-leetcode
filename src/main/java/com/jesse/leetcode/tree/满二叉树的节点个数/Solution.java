package com.jesse.leetcode.tree.满二叉树的节点个数;

import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/6/28
 */
public class Solution {


    public int countNodes(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return (int)Math.pow(2, h) - 1;
    }
}

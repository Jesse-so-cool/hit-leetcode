package com.jesse.leetcode.tree.二叉树中的最大路径和;

import com.jesse.leetcode.entity.TreeNode;

/**
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * @author jesse hsj
 * @date 2020/7/3 11:13
 */
public class Solution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }

    //返回经过node但不以node为parent(left right只选择其一)的最大路径和
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Integer.max(0, helper(node.left));
        int right = Integer.max(0, helper(node.right));
        max = Integer.max(max,(node.val + left + right));
        return node.val+Integer.max(left,right);
    }
}

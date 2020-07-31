package com.jesse.leetcode.tree.二叉搜索树的最小绝对差;

import com.jesse.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 *
 * @author jesse hsj
 * @date 2020/7/28 11:21
 */
public class Solution {
    public int getMinimumDifference(TreeNode root) {
        int prevNode = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        Stack stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Object pop = stack.pop();
            if (pop instanceof TreeNode) {
                TreeNode node = (TreeNode) pop;
                if (node.right!=null) stack.push(node.right);
                stack.push(node.val);
                if (node.left!=null) stack.push(node.left);
            }else {
                min = Integer.min(min,Math.abs((int) pop - prevNode));
                prevNode = (int) pop;
            }
        }
        return min;
    }
}

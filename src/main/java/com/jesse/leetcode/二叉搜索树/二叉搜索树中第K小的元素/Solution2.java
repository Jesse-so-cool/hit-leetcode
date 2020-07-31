package com.jesse.leetcode.二叉搜索树.二叉搜索树中第K小的元素;

import com.jesse.leetcode.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 迭代
 *
 * @author jesse hsj
 * @date 2020/7/23 10:53
 */
public class Solution2 {

    public static void main(String[] args) {
        Integer[] nums = {3, 1, 4, null, 2};
        TreeNode t = TreeNode.create(nums);
        System.out.println(new Solution2().kthSmallest(t, 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack stack = new Stack();
        stack.add(root);

        while (!stack.isEmpty()) {
            Object o = stack.pop();
            if (o == null)
                continue;
            if (o instanceof TreeNode) {
                TreeNode node = (TreeNode) o;
                stack.add(node.right);
                stack.add(node.val);
                stack.add(node.left);
            } else {
                if (--k == 0) {
                    return (int) o;
                }
            }
        }
        return -1;
    }

}

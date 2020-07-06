package com.jesse.leetcode.tree.二叉树展开为链表;

import com.jesse.leetcode.entity.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 *
 * @author jesse hsj
 * @date 2020/7/6 16:55
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] t = new Integer[]{1,2,3,4,5,null,6};
        Solution solution = new Solution();
        TreeNode root = TreeNode.create(t);
        solution.flatten(root);
        System.out.println();
    }

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode rightNode = root.left;
                while (rightNode.right != null) {
                    rightNode = rightNode.right;
                }
                TreeNode temp = root.right;
                root.right = root.left;
                rightNode.right = temp;
                root.left = null;

                root = root.right;
            }
        }
    }
}

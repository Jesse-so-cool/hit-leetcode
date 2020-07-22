package com.jesse.leetcode.tree.二叉树的所有路径;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 *
 * @author jesse hsj
 * @date 2020/7/21 10:02
 */
public class Solution {


    public static void main(String[] args) {
        Integer[] nums = {3, 1, 4, null, 2};

        System.out.println(new Solution().binaryTreePaths(TreeNode.create(nums)));
    }

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return res;
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        backtrack(root, sb);
        return res;
    }

    private void backtrack(TreeNode root, StringBuffer sb) {
        if (root.left == null && root.right == null)
            res.add(sb.toString());

        if (root.left != null) {
            String str = "->" + root.left.val;
            sb.append(str);
            backtrack(root.left, sb);
            sb.delete(sb.length() - str.length(), sb.length());
        }
        if (root.right != null) {
            String str = "->" + root.right.val;
            sb.append(str);
            backtrack(root.right, sb);
            sb.delete(sb.length() - str.length(), sb.length());
        }
    }

}

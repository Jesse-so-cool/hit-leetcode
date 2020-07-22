package com.jesse.leetcode.tree.二叉树的后序遍历;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2020/7/22 13:25
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<Object> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object o = stack.pop();
            if (o == null)
                continue;
            if (o instanceof TreeNode) {
                TreeNode node = (TreeNode) o;
                stack.push(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                list.add((Integer) o);
            }
        }
        return list;
    }
}

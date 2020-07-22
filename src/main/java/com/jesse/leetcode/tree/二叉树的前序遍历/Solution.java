package com.jesse.leetcode.tree.二叉树的前序遍历;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * //迭代写法
 *
 * @author jesse hsj
 * @date 2020/7/12
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] t = {1, 4, 2, 3};
        System.out.println(new Solution().inorderTraversal(TreeNode.create(t)));
    }

    class SignNode {
        TreeNode node;
        int sign;

        public SignNode(TreeNode node, int sign) {
            this.node = node;
            this.sign = sign;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<Object> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object o = stack.pop();
            if (o == null)
                continue;
            if (o instanceof TreeNode) {
                TreeNode node = (TreeNode) o;
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                stack.push(node.val);
            } else {
                list.add((Integer) o);
            }
        }
        return list;
    }

    public List<Integer> test(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null)
                continue;
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            stack.push(node);
        }
        return list;
    }


}

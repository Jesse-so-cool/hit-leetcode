package com.jesse.leetcode.tree.二叉树的中序遍历;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * //迭代写法
 * @author jesse hsj
 * @date 2020/7/12
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] t = {1,4,2,3};
        System.out.println(new Solution().inorderTraversal(TreeNode.create(t)));
    }


    class SignNode {
        TreeNode node;
        int sign;
        public SignNode (TreeNode node,int sign) {
            this.node = node;
            this.sign = sign;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<SignNode> stack = new Stack();
        stack.push(new SignNode(root,0));
        while (!stack.isEmpty()) {
            SignNode signNode = stack.pop();
            TreeNode node = signNode.node;
            if (node == null)
               continue;
            if (signNode.sign == 0) {
                if (node.right!=null) stack.push(new SignNode(node.right,0));
                stack.push(new SignNode(node,1));
                if (node.left!=null) stack.push(new SignNode(node.left,0));
            }else {
                list.add(node.val);
            }
        }
        return list;
    }
}

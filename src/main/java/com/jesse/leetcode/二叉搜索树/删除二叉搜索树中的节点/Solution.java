package com.jesse.leetcode.二叉搜索树.删除二叉搜索树中的节点;

import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/7/26
 */
public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        int val = root.val;
        if (val > key) {
            root.left = deleteNode(root.left,key);
        }else if (val < key) {
            root.right = deleteNode(root.right,key);
        }else {
            //当前节点没有左子树
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }else {
                TreeNode preNode = preNode(root);
                preNode.right = root.right;
                return root.left;
            }
        }
        return root;
    }

    /**
     * 前继结点
     * @param root
     * @return
     */
    private TreeNode preNode(TreeNode root) {
        TreeNode left = root.left;
        while (left.right != null) {
            left = left.right;
        }
        return left;
    }
}

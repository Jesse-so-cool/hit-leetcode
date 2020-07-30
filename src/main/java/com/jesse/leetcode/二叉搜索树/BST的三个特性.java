package com.jesse.leetcode.二叉搜索树;

import com.jesse.leetcode.entity.TreeNode;

import java.util.LinkedList;

/**
 * @author jesse hsj
 * @date 2020/7/26
 */
public class BST的三个特性 {

    /**
     * 1. 二叉搜索树的中序遍历的序列是递增排序的序列。中序遍历的遍历次序：Left -> Node -> Right。
     */
    public LinkedList<Integer> inorder(TreeNode root, LinkedList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    /**
     * Successor 代表的是中序遍历序列的下一个节点。即比当前节点大的最小节点，简称后继节点。
     *          先取当前节点的右节点，然后一直取该节点的左节点，直到左节点为空，则最后指向的节点为后继节点。
     */
    public TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root;
    }

    /**
     * Predecessor 代表的是中序遍历序列的前一个节点。即比当前节点小的最大节点，简称前驱节点。先取当前节点的左节点，然后取该节点的右节点，直到右节点为空，则最后指向的节点为前驱节点。
     */
    public TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root;
    }
}

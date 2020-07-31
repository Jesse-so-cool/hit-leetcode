package com.jesse.leetcode.tree.从前序与中序遍历序列构造二叉树;

import com.jesse.leetcode.entity.TreeNode;

import java.util.HashMap;

/**
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author jesse hsj
 * @date 2020/7/3 11:28
 */
public class Solution {


    private HashMap<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int prelow, int prehigh, int inlow, int inhigh) {
        if (prelow > prehigh || inlow > inhigh) return null;
        int rootVal = preorder[prelow];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = indexMap.get(rootVal);
        int leftNodeCount = rootIndex - prelow;

        root.left = helper(preorder, inorder,prelow+1, prelow +leftNodeCount, inlow, rootIndex - 1);
        root.right = helper(preorder, inorder, prelow +leftNodeCount+1,prehigh,rootIndex+1,inhigh);
        return root;
    }
}

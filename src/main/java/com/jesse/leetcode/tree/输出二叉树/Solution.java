package com.jesse.leetcode.tree.输出二叉树;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/8/2
 */
public class Solution {
    String[][] res = null;
    public List<List<String>> printTree(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        int h = height(root);
        res = new String[h][(1 << h) - 1];
        for (String[] re : res) {
            Arrays.fill(re,"");
        }
        helper(root,0,0,(1 << h) - 1);

        List<List<String>> ls = new ArrayList<>();
        for (String[] re : res) {
            ls.add(Arrays.asList(re));
        }
        return ls;
    }

    private void helper(TreeNode root, int h, int low, int high) {
        if (root == null) return;
        int mid =low + (high - low) / 2;
        res[h][mid] = root.val+"";
        helper(root.left,h+1,low,mid-1);
        helper(root.right,h+1,mid+1,high);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Integer.max(height(root.left),height(root.right));
    }
}

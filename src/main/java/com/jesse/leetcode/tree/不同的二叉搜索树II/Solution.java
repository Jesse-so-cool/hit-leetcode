package com.jesse.leetcode.tree.不同的二叉搜索树II;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/7/16
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new Solution().generateTrees(3)));
    }


    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }

        return helper(1,n);
    }

    private List<TreeNode> helper(int low, int high) {
        List<TreeNode> res = new ArrayList<>();
        if (low > high){
            res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftList = helper(low, i - 1);
            List<TreeNode> rightList = helper(i+1, high);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    res.add(treeNode);
                }
            }
        }

        return res;
    }

}

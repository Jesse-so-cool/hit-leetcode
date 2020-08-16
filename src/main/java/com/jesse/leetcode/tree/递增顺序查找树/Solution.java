package com.jesse.leetcode.tree.递增顺序查找树;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/8/10
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {5, 3, 6, 2, 4, null, 8, 1};
        System.out.println(new Gson().toJson(new Solution().increasingBST(TreeNode.create(nums))));
    }

    TreeNode temp = null;
    TreeNode res = null;

    public TreeNode increasingBST(TreeNode root) {

        if (root == null)
            return null;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (temp == null) {
            temp = root;
            res = root;
        } else {
            root.left = null;
            temp.right = root;
            temp = root;
        }

        inOrder(root.right);
    }
}

package com.jesse.leetcode.sort.二叉搜索树的第k大节点;

import com.jesse.leetcode.entity.TreeNode;

/**
 *
 * @author jesse hsj
 * @date 2020/7/21 9:39
 */
public class Solution {


    public static void main(String[] args) {
        Integer[] nums = {3,1,4,null,2};
        System.out.println(new Solution().kthLargest(TreeNode.create(nums),1));
    }

    int res = 0,k=0;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        midOrder(root);
        return res;
    }

    private void midOrder(TreeNode root) {
        if (root == null || k==0) {
            return;
        }
        midOrder(root.right);

        if (--k == 0) {
            res = root.val;
            return;
        }
        midOrder(root.left);
    }
}

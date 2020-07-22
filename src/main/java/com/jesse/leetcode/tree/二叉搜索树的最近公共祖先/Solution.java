package com.jesse.leetcode.tree.二叉搜索树的最近公共祖先;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2020/7/22 14:38
 */
public class Solution {
    public static void main(String[] args) {
            Integer[] nums = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode t = TreeNode.create(nums);
        System.out.println(new Gson().toJson(new Solution().lowestCommonAncestor(t,new TreeNode(2),new TreeNode(8))));
        }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }
}

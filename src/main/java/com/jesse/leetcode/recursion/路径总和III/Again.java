package com.jesse.leetcode.recursion.路径总和III;

import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/8/4
 */
public class Again {

    public static void main(String[] args) {
        //Integer[] root = {10,5,-3,3,2};
        Integer[] root = {10,5,-3,3,2,null,11,3,-2,null,1};
        //Integer[] root = {1,-2,-3,1,3,-2,null,-1};

        System.out.println(new Again().pathSum(TreeNode.create(root), 8));
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum)
                + startWithRoot(root.left, sum - root.val) + startWithRoot(root.right, sum - root.val)
                + (root.val == sum ? 1 : 0);
    }

    private int startWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        return startWithRoot(root.left,sum-root.val) + startWithRoot(root.right,sum-root.val)
                + (root.val == sum ? 1 : 0);
    }
}

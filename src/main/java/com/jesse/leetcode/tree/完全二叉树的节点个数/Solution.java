package com.jesse.leetcode.tree.完全二叉树的节点个数;

import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/6/28
 */
public class Solution {
    //最差的解法 没有利用完全二叉树的性质
    public int badCountNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //由满二叉树的节点解法可以类推

    /**
     * 这个算法的时间复杂度是 O(logN*logN)，这是怎么算出来的呢？
     *
     * 直觉感觉好像最坏情况下是 O(N*logN) 吧，因为之前的 while 需要 logN 的时间，最后要 O(N) 的时间向左右子树递归：
     *
     * return 1 + countNodes(root.left) + countNodes(root.right);
     * 关键点在于，这两个递归只有一个会真的递归下去，另一个一定会触发hl == hr而立即返回，不会递归下去。
     */
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        // 记录左、右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右子树的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1;
        }
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes(root.left) + countNodes(root.right);

    }
}

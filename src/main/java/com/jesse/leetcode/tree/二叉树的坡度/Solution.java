package com.jesse.leetcode.tree.二叉树的坡度;

import com.jesse.leetcode.entity.TreeNode;

/**
 * 输入：
 *     1
 *    / \
 *   2  3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * <p>
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 *
 * todo
 * 二叉树遍历比较特别的题目
 *
 * 明明是求坡度，但是写得遍历确实求节点的和
 * 在中间才穿插求坡度
 * @author jesse hsj
 * @date 2020/7/29 11:36
 */
public class Solution {

    int tilt = 0;
    public int findTilt(TreeNode root) {
        postOrder(root);
        return tilt;
    }

    //返回节点值
    public int postOrder(TreeNode root) {
        if (root == null)
            return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int abs = Math.abs(left - right);
        tilt += abs;
        return left + right + root.val;
    }
}

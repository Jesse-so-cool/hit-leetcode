package com.jesse.leetcode.tree;

import com.jesse.leetcode.entity.MyTreeNode;

/**
 * @author jesse hsj
 * @date 2020/1/18
 */
public class SumRootToLeafTree {

    //功能是 将root到左右节点的值相加
    public static int sumRootToLeaf(MyTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) return root.val;

        int a = root.val << 1;
        if (root.left != null) root.left.val = a + root.left.val;
        if (root.right != null) root.right.val = a + root.right.val;
        return sumRootToLeaf (root.left)+sumRootToLeaf (root.right);
    }


    public static void main(String[] args) {
        MyTreeNode treeNode = MyTreeNode.create(new Integer[]{1, 0, 1,0 ,1, 0, 1});
        System.out.println(sumRootToLeaf(treeNode));
    }
}

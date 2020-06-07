package com.jesse.leetcode.tree;

import com.jesse.leetcode.entity.MyTreeNode;

/**
 *将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中  一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @author jesse hsj
 * @date 2020/1/18
 */
public class SortedArrayToBST {

    public static MyTreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0, nums.length - 1);
    }

    //把数组的from->to 的数据 build出BST
    public static MyTreeNode sortedArrayToBST(int[] nums, int from , int to) {
        if (to < from) {
            return null;
        }
        int index = (from+to)/2;
        MyTreeNode node = new MyTreeNode(nums[index]);
        node.left = sortedArrayToBST(nums,from, index - 1);
        node.right = sortedArrayToBST(nums,index+1, to);

        return node;
    }

    public static void main(String[] args) {
        MyTreeNode myTreeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});

        MyTreeNode.preOrder(myTreeNode);
        System.out.println();
        MyTreeNode.midOrder(myTreeNode);
    }
}

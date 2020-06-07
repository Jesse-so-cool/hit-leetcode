package com.jesse.leetcode.tree;

import com.jesse.leetcode.entity.MyTreeNode;

/**
 * @author jesse hsj
 * @date 2020/1/17
 */
public class InvertTree {

    public static MyTreeNode invertTree(MyTreeNode root) {
        if (root == null) {
            return null;
        }
        MyTreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {

        MyTreeNode node = MyTreeNode.create(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        MyTreeNode.preOrder(node);

        System.out.println();
        MyTreeNode myTreeNode = invertTree(node);
        MyTreeNode.preOrder(myTreeNode);

    }
}

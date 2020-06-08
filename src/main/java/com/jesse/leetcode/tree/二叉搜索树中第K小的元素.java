package com.jesse.leetcode.tree;

import com.jesse.leetcode.entity.MyTreeNode;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2020/6/8 15:27
 */
public class 二叉搜索树中第K小的元素 {

    static int num = 0;
    static int res;
    public static void main(String[] args) {
        Integer[] datas = new Integer[]{4, 2, 5,1 ,3};

        BSTree bsTree = BSTree.create(datas);
        BSTree.midOrder(bsTree);

        kthMin(bsTree,3);
        System.out.println();
        System.out.println(res);
    }

    private static void kthMin(BSTree root, int k) {
        if (root != null) {
            kthMin(root.left,k);
            if (root != null) {
                num++;
            }
            if (num == k)
                res = root.val;
            kthMin(root.right,k);
        }

    }

}

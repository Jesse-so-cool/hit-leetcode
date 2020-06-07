package com.jesse.leetcode.tree;

import com.jesse.leetcode.entity.MyTreeNode;

/**
 * @author jesse hsj
 * @date 2020/1/18
 */
public class MergeTrees {

    //合并二叉树  第一个是主二叉树 直接输出
    public static MyTreeNode mergeTrees(MyTreeNode t1, MyTreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);

        return t1;

    }

    public static void main(String[] args) {

    }
}

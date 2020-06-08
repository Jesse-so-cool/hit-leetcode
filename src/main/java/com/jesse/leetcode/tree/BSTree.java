package com.jesse.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树
 * 还没有实现二叉搜索树的功能
 * @author jesse hsj
 * @date 2020/1/17
 */
public class BSTree {

    public int val;
    public BSTree left;
    public BSTree right;

    public BSTree(int x) {
        val = x;
    }

    public static BSTree create(Integer datas[]) {//初始化二叉树,将传进来的值创建为二叉树
        List<BSTree> list = new ArrayList<BSTree>();//新建一个list集合，将数据变为各个节点
        for (Integer data : datas) {
            if (data == null) {
                list.add(null);
            } else {
                list.add(new BSTree(data));

            }
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if ((i * 2 + 1) < list.size()) {
                list.get(i).left = list.get(i * 2 + 1);
            }
            if ((i * 2 + 2) < list.size()) {
                list.get(i).right = list.get(i * 2 + 2);
            }
        }
        return list.get(0);
    }

    public static void preOrder(BSTree root) {//利用递归实现前序遍历，输出打印结果
        if (root != null) {
            if (root.val != -1) {
                System.out.print(" " + root.val);
            }else {
                System.out.print(" " + null);
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void midOrder(BSTree root) {//利用递归实现前序遍历，输出打印结果
        if (root != null) {
            midOrder(root.left);
            if (root != null) {
                System.out.print(" " + root.val);
            }else {
                System.out.print(" " + null);
            }
            midOrder(root.right);
        }
    }

    public static void postOrder(BSTree root) {//利用递归实现前序遍历，输出打印结果
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            if (root.val != -1) {
                System.out.print(" " + root.val);
            }else {
                System.out.print(" " + null);
            }
        }
    }

    public static void main(String[] args) {
        BSTree myTreeNode = BSTree.create(new Integer[]{1, 2, 3, 4, 5, 6});

        preOrder(myTreeNode);
        System.out.println();
        midOrder(myTreeNode);
        System.out.println();
        postOrder(myTreeNode);
    }

}

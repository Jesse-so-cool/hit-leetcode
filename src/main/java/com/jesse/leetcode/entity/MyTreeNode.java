package com.jesse.leetcode.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/1/17
 */
public class MyTreeNode {

    public int val;
    public MyTreeNode left;
    public MyTreeNode right;

    public MyTreeNode(int x) {
        val = x;
    }

    public static MyTreeNode create(Integer datas[]) {//初始化二叉树,将传进来的值创建为二叉树
        List<MyTreeNode> list = new ArrayList<MyTreeNode>();//新建一个list集合，将数据变为各个节点
        for (Integer data : datas) {
            if (data == null) {
                list.add(new MyTreeNode(-1));
            } else {
                list.add(new MyTreeNode(data));

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

    public static void preOrder(MyTreeNode root) {//利用递归实现前序遍历，输出打印结果
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

    public static void midOrder(MyTreeNode root) {//利用递归实现前序遍历，输出打印结果
        if (root != null) {
            midOrder(root.left);
            if (root.val != -1) {
                System.out.print(" " + root.val);
            }else {
                System.out.print(" " + null);
            }
            midOrder(root.right);
        }
    }

    public static void postOrder(MyTreeNode root) {//利用递归实现前序遍历，输出打印结果
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
        MyTreeNode myTreeNode = MyTreeNode.create(new Integer[]{1, 2, 3, 4, 5, 6});

        preOrder(myTreeNode);
        System.out.println();
        midOrder(myTreeNode);
        System.out.println();
        postOrder(myTreeNode);
    }

}

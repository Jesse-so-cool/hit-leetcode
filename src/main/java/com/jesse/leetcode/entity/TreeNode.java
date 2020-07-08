package com.jesse.leetcode.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 答题专用
 * @author jesse hsj
 * @date 2020/1/17
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode create(Integer datas[]) {//初始化二叉树,将传进来的值创建为二叉树
        List<TreeNode> list = new ArrayList<TreeNode>();//新建一个list集合，将数据变为各个节点
        for (Integer data : datas) {
            if (data == null) {
                list.add(null);
            } else {
                list.add(new TreeNode(data));
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

    public static void preOrder(TreeNode root) {//利用递归实现前序遍历，输出打印结果
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

    public static void midOrder(TreeNode root) {//利用递归实现前序遍历，输出打印结果
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

    public static void postOrder(TreeNode root) {//利用递归实现前序遍历，输出打印结果
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
        TreeNode myTreeNode = TreeNode.create(new Integer[]{3,9,20,null,null,15,7});

        preOrder(myTreeNode);
        System.out.println();
        midOrder(myTreeNode);
        System.out.println();
        postOrder(myTreeNode);
    }

    public List<TreeNode> adj() {

        List<TreeNode> ls
                 = new ArrayList<>();

        if (this.left!=null) ls.add(this.left);
        if (this.right!=null) ls.add(this.right);
        return ls;
    }
}

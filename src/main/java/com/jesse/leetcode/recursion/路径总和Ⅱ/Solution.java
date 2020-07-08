package com.jesse.leetcode.recursion.路径总和Ⅱ;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * @author jesse hsj
 * @date 2020/7/7 9:42
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] integers = {-2, null, -3};
        System.out.println(new Solution().pathSum(TreeNode.create(integers), -5));
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return ll;

        List<Integer> li = new ArrayList<>();
        li.add(root.val);
        hasPathSum(root, sum - root.val, li);
        return ll;
    }
    public void hasPathSum(TreeNode root, int sum, List<Integer> li) {
        if (sum == 0 && root.left == null && root.right == null){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(li);
            ll.add(temp);
        }

        if (root.left != null) {
            li.add(root.left.val);
            int size = li.size();
            hasPathSum(root.left, sum - root.left.val, li);
            li.remove(size-1);
        }

        if (root.right != null) {
            li.add(root.right.val);
            int size = li.size();
            hasPathSum(root.right, sum - root.right.val, li);
            li.remove(size-1);
        }
    }

    List<List<Integer>> ll = new ArrayList<>();


}

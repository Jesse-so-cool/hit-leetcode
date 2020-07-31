package com.jesse.leetcode.BFSAndDFS.bfs.二叉树的锯齿形层次遍历;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/7/19
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(new Gson().toJson(new Solution().zigzagLevelOrder(TreeNode.create(nums))));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean isFlag = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            //使用双链表控制从左进还是从右进
            LinkedList<Integer> re = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll != null) {
                    if (poll.left != null) {
                        deque.add(poll.left);
                    }
                    if (poll.right != null) {
                        deque.add(poll.right);
                    }
                    if (isFlag)
                        re.addLast(poll.val);
                    else
                        re.addFirst(poll.val);
                }
            }
            isFlag = !isFlag;
            res.add(re);
        }

        return res;
    }

}

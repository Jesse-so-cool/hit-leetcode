package com.jesse.leetcode.BFSAndDFS.bfs.二叉树的层次遍历II;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2021/3/22
 */
public class Again {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(new Again().levelOrder(treeNode));
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> re = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.pop();
                re.add(pop.val);
                if (pop.left!=null) queue.offer(pop.left);
                if (pop.right!=null) queue.offer(pop.right);
            }
            res.addFirst(re);
        }
        return res;
    }

}

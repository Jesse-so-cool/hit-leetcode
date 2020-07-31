package com.jesse.leetcode.tree.二叉树的右视图;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 *
 * @author jesse hsj
 * @date 2020/7/23 11:16
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int k = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            k++;
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (res.size() < k) {
                    res.add(t.val);
                }
                if(t.right != null) queue.add(t.right);
                if(t.left != null) queue.add(t.left);
            }
        }
        return res;
    }

}

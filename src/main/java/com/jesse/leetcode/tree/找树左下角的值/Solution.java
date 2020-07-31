package com.jesse.leetcode.tree.找树左下角的值;

import com.jesse.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *
 * @author jesse hsj
 * @date 2020/7/29 9:52
 */
public class Solution {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()) {
            int k = queue.size();
            res = queue.peek().val;
            for (int i = 0;i<k;i++) {
                TreeNode t = queue.poll();
                if (t.left!=null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
        }
        return res;
    }


}

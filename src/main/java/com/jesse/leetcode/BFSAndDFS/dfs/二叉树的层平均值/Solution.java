package com.jesse.leetcode.BFSAndDFS.dfs.二叉树的层平均值;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/8/1
 */
public class Solution {
    List<Integer> count = new ArrayList<>();
    List<Double> res = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }

    public void dfs(TreeNode t, int i) {
        if (t==null) return;

        if (i < count.size()) {
            res.set(i,res.get(i)+t.val);
            count.set(i,count.get(i)+1);
        }else {
            res.add((double) t.val);
            count.add(1);
        }
        dfs(t.left,i+1);
        dfs(t.right,i+1);
    }
}

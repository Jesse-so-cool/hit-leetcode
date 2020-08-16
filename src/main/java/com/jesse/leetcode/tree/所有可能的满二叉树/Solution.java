package com.jesse.leetcode.tree.所有可能的满二叉树;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jesse hsj
 * @date 2020/8/10
 */
public class Solution {
    Map<Integer,List<TreeNode>> cache = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if (cache.containsKey(N))
            return cache.get(N);
        List<TreeNode> res = new ArrayList<>();
        if (N==1)
            res.add(new TreeNode());
        else {
            for (int i = 1; i <= N-1; i++) {
                List<TreeNode> lefts = allPossibleFBT(i);
                for (TreeNode left : lefts) {
                    List<TreeNode> rights = allPossibleFBT(N-i-1);
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode();
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
        }
        cache.put(N,res);
        return res;
    }
}

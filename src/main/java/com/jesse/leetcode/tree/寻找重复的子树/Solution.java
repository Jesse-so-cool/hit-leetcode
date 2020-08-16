package com.jesse.leetcode.tree.寻找重复的子树;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jesse hsj
 * @date 2020/8/1
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, 4, 5, 4, 7};
        System.out.println(new Gson().toJson(new Solution().findDuplicateSubtrees(TreeNode.create(nums))));
    }

    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        return uid;
    }
}

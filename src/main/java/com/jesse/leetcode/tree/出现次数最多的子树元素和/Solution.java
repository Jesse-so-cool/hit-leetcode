package com.jesse.leetcode.tree.出现次数最多的子树元素和;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2020/7/28 10:47
 */
public class Solution {
    Map<Integer,Integer> map = new HashMap();
    List<Integer> res = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        //自底向上
        dfs(root);
        int[] re = new int[res.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = res.get(i);
        }
        return re;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val + left + right;
        map.put(sum,map.getOrDefault(sum,0)+1);
        if (map.get(sum) > max ){
            max = map.get(sum);
            res.clear();
            res.add(sum);
        }else if (map.get(sum) == max) {
            res.add(sum);
        }
        return sum;
    }
}

package com.jesse.leetcode.BFSAndDFS.dfs.单词拆分;

import com.jesse.leetcode.entity.TreeNode;

import java.util.*;

/**
 *
 * @author jesse hsj
 * @date 2020/7/31 11:05
 */
public class Solution {
    public static void main(String[] args) {
            Integer[] nums = {3, 1, 4, null, 2};
            TreeNode t = TreeNode.create(nums);
            System.out.println(new Solution().wordBreak("leetcode",Arrays.asList("leet","code")));
        }
    Set<String> set = null;
    Map<String,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return dfs(s);
    }

    private boolean dfs(String s) {
        if (map.containsKey(s))
            return map.get(s);
        if (set.contains(s))
            return true;
        int length = s.length();
        for (int i = 1; i <= length; i++) {
           if (set.contains(s.substring(0,i)) && dfs(s.substring(i,length)) ){
               return true;
           }
        }
        map.put(s,false);
        return false;
    }
}

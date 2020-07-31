package com.jesse.leetcode.BFSAndDFS.dfs.单词拆分Ⅱ;

import com.jesse.leetcode.entity.TreeNode;

import java.util.*;

/**
 *
 * @author jesse hsj
 * @date 2020/7/31 13:38
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {3, 1, 4, null, 2};
        TreeNode t = TreeNode.create(nums);
        System.out.println(new Solution().wordBreak("aa",Arrays.asList("a","aa")));
    }
    Set<String> set = null;
    Map<String,List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        StringBuffer sb = new StringBuffer();
        //dfs(sb,s);
        return dfs(sb,s);
    }

    private List<String> dfs(StringBuffer sb, String s) {
        List<String> res = new ArrayList<>();
        if (cache.containsKey(s)) {
            List<String> list = cache.get(s);
            for (String ls : list) {
                res.add(sb.append(ls).substring(1));
            }
            return list;
        }

        if (s.length() == 0){
            //res.add(sb.substring(1));
            return new ArrayList<>();
        }

        int length = s.length();
        for (int i = 1; i <= length; i++) {
            String substring = s.substring(0, i);
            if (!set.contains(substring)){
                continue;
            }
            sb.append(" "+substring);
            String substring1 = s.substring(i, length);
            List<String> ss = dfs(sb, substring1);
            for (String s1 : ss) {
                res.add(new StringBuffer(sb).append(s1).substring(1));
            }
            sb.delete(sb.length()-substring.length()-1,sb.length());
        }
        cache.put(s,res);
        return res;
    }

}

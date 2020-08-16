package com.jesse.leetcode.BFSAndDFS.dfs.单词拆分Ⅱ;

import com.jesse.leetcode.entity.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author jesse hsj
 * @date 2020/7/31 13:38
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {3, 1, 4, null, 2};
        TreeNode t = TreeNode.create(nums);
        System.out.println(new Solution().wordBreak("catsanddog",Arrays.asList("cats","and","dog","dog","dog")));
    }
    Set<String> set = null;
    Map<String,List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        StringBuffer sb = new StringBuffer();
        List<String> dfs = dfs(s);//此时的string最后都会多出一个空格
        List<String> collect = dfs.stream().map(ls -> ls.substring(0, ls.length() - 1)).collect(Collectors.toList());
        return collect;
    }
    //dfs且返回字符串s的拆分组合
    private List<String> dfs(String s) {
        List<String> res = new ArrayList<>();
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (s.length() == 0){
            res.add("");
            return res;
        }
        int length = s.length();
        //由于substring原因，从1开始
        for (int i = 1; i <= length; i++) {
            List<String> re = new ArrayList<>();
            String prefix = s.substring(0, i);
            if (!set.contains(prefix)){
                continue;
            }
            String suffix = s.substring(i, length);
            List<String> ss = dfs(suffix);
            for (String su : ss)
                re.add(prefix + " " + su);
            res.addAll(re);
        }
        cache.put(s,res);
        return res;
    }

}

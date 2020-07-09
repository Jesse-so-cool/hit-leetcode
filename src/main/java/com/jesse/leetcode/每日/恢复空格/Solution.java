package com.jesse.leetcode.每日.恢复空格;

import java.util.Arrays;

/**
 * 把文章断开，要求未识别的字符最少，返回未识别的字符数
 *
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 *
 *
 * @author jesse hsj
 * @date 2020/7/9 10:02
 */
public class Solution {

    public static void main(String[] args) {
        String[] s = {"looked","just","like","her","brother"};
        System.out.println(new Solution().respace(s, "jesslookedjustliketimherbrother"));
    }

    public int respace(String[] dictionary, String sentence) {
        //dp[i] 是前i个字符串未识别的字符最少数
        int[] dp = new int[sentence.length()+1];
        //最大也不超过sentence
        Arrays.fill(dp,sentence.length()+1);
        //base case
        dp[0] = 0;

        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        for (int i = 1; i <= sentence.length(); i++) {
            Trie tt = trie;
            //先用上
            //dp[i] = dp[i-1]+1;
            int min = sentence.length()+1;
            for (int j = i; j > 0 ; j--) {
                int hash = sentence.charAt(j - 1) - 'a';
                if (tt.links[hash] == null) {
                    break;
                }else if (tt.links[hash].isEnd){
                    //这个是不太理解的
                    min = Integer.min(min,dp[j-1]);
                }

                tt = tt.links[hash];
            }

            dp[i] = Integer.min(dp[i-1]+1,min);
        }
        return dp[sentence.length()];
    }
    class Trie {
        private Trie[] links;

        private boolean isEnd;

        public Trie() {
            links = new Trie[26];
            isEnd= false;
        }
        //这里反向插入
        public void insert(String word) {
            Trie trie = this;
            for (int i = word.length()-1; i >= 0; i--) {
                char c = word.charAt(i);
                if (trie.links[c-'a']==null) {
                    trie.links[c-'a'] = new Trie();
                }
                trie = trie.links[c-'a'];
            }
            trie.isEnd = true;
        }
    }

}

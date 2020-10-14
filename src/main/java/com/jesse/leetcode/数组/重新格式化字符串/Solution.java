package com.jesse.leetcode.数组.重新格式化字符串;

import com.google.gson.Gson;

/**
 * @author jesse hsj
 * @date 2020/8/18
 */
public class Solution {
        public static void main(String[] args) {
                int[] nums = {1,1,1,2,2,3,3};
                System.out.println(new Gson().toJson(new Solution().reformat("covid2019")));
        }
    public String reformat(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] c = s.toCharArray();
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                sb1.append(c[i]);
            } else {
                sb2.append(c[i]);
            }
        }
        if (Math.abs(sb1.length() - sb2.length()) > 1)
            return "";
        int max = Math.max(sb1.length(), sb2.length());
        Boolean isSb1 = null;
        for (int i = 0; i < max; i++) {
            try {
                res.append(sb1.charAt(i));
            } catch (Exception e) {
                isSb1 = true;
                break;
            }
            try {
                res.append(sb2.charAt(i));
            } catch (Exception e) {
                return res.toString();
            }
        }

        if (isSb1 == null) {
            return res.toString();
        } else if (isSb1) {
            //说明isSb1长度比较小
            char c1 = sb2.charAt(sb2.length() - 1);
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(c1));
            res = stringBuffer.append(res);
        }
        return res.toString();

    }
}
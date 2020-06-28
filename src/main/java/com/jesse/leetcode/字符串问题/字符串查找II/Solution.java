package com.jesse.leetcode.字符串问题.字符串查找II;

/**
 * 输入：source = "abcdef"， target = "bcd"
 * 输出：1
 * 解释：
 * 字符串第一次出现的位置为1。
 *
 * @author jesse hsj
 * @date 2020/6/20
 */
public class Solution {

    int BASE = 1000000;

    //Rabin Karp算法
    //我们要极大避免调用equals
    //复杂度分析
    //  时间复杂度：O(N)，计算 target 字符串的哈希值需要 O(L)时间，之后需要执行 (N - L) 次循环，每次循环的计算复杂度为常数。
    //  空间复杂度：O(1)
    public int strStr2(String source, String target) {
        if (target == null || source == null) {
            return -1;
        }
        int length = target.length();
        if (length == 0) {
            return 0;
        }
        int power = 1;
        //疑问是 为什么可以一直模 还没有问题
        //31^m
        for (int i = 0; i < length; i++) {
            power = (power * 31) % BASE;
        }

        //target的hashcode
        int targetHashcode = 0;
        for (int i = 0; i < length; i++) {
            targetHashcode = (targetHashcode * 31 + target.charAt(i)) % BASE;
        }

        int hashcode = 0;
        for (int i = 0; i < source.length(); i++) {
            hashcode = (hashcode * 31 + source.charAt(i)) % BASE;
            if (i < length - 1) {
                continue;
            }

            if (i >= length) {
                hashcode = (hashcode - power*source.charAt(i-length))%BASE;
                if (hashcode < 0) hashcode += BASE;
            }

            if (hashcode == targetHashcode) {
                //这里是极少可能调用equals
                if (source.substring(i-length+1,i+1).equals(target)) {
                    return i-length+1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().strStr2("abcd", "cd"));
    }
}

package com.jesse.leetcode.每日.跳水板;

import java.util.*;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 *输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * @author jesse hsj
 * @date 2020/7/8 10:00
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().divingBoard(1,1,100000);
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if(shorter==longer){
            return new int[]{k*longer};
        }
        int[] res = new int[k+1];

        for (int i = 0; i <= k; i++) {
            res[i] = shorter*(i) + longer*(k-i);
        }
        return res;
    }
}

package com.jesse.leetcode.大数据算法题;

import java.util.BitSet;

/**
 * 40亿个非负整数中找到未出现的数
 *
 * @author jesse hsj
 * @date 2020/12/3 11:16
 */
public class NotExistNum {

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,8,9,8,9,10};//假设这里有40亿个数
        BitSet bitSet = new BitSet(10);
        System.out.println("bitset size = " + bitSet.size());
        for (int i = 0; i < nums.length; i++) {
            bitSet.set(nums[i]);
        }
        for (int i = 0; i < bitSet.size(); i++) {
            boolean b = bitSet.get(i);
            if (!b){
                System.out.println(i);
            }
        }

    }

}

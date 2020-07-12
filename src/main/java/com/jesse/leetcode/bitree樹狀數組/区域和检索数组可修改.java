package com.jesse.leetcode.bitree樹狀數組;

/**
 *
 * 区域和检索-数组可修改
 * @author jesse hsj
 * @date 2020/6/9
 */
public class 区域和检索数组可修改 {
    BIT bit = null;
    int[] datas;
    public static void main(String[] args) {
        int [] datas = {1,2,3,4,5,6};
        区域和检索数组可修改 w = new 区域和检索数组可修改(datas);
        System.out.println(w.sumRange(0, 2));
        w.update(1, 2);
        System.out.println(w.sumRange(0, 2));


    }
    public 区域和检索数组可修改(int[] nums) {
        bit = new BIT();
        bit.datas = new int[nums.length];
        datas = nums;
        for (int i = 0; i < nums.length; i++) {
            bit.update(i+1,nums[i]);
        }

    }

    public void update(int i, int val) {
        bit.update(i+1,val-datas[i]);
        datas[i] = val;
    }

    public int sumRange(int i, int j) {
        return bit.query(j+1)-bit.query(i);
    }
}

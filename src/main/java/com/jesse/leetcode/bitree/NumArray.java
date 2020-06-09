package com.jesse.leetcode.bitree;

/**
 * @author jesse hsj
 * @date 2020/6/9
 */
public class NumArray {
    private BIT bit;
    private int []data;

    public static void main(String[] args) {
        int [] Ctree = {1,2,3,4,5,6};
        NumArray numArray = new NumArray(Ctree);
        System.out.println(numArray.sumRange(0, 1));
    }





    public NumArray(int[] nums) {
        bit=new BIT(nums);
        data=new int [nums.length];
        for(int i=0;i<nums.length;i++)
            data[i]=nums[i];
    }
    public void update(int i, int val) {
        bit.updata(i,val-data[i]);
        data[i]=val;
    }

    public int sumRange(int i, int j) {
        return bit.query(j)-bit.query(i-1);
    }
}

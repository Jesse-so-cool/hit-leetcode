package com.jesse.leetcode.bitree;

/**
 * up主 搭救 https://www.bilibili.com/video/BV1LW411e7jo?from=search&seid=1815853072203989825
 *
 * @author jesse hsj
 * @date 2020/6/9
 */
public class BIT2 {
    int[] datas ;

    private int lowbit(int x) {
        return x&(-x);
    }

    public void update(int x,int val) {
        while (x <= datas.length) {
            datas[x-1] += val; //这里必须是+  因为初始化时一个一个update的 不+的话 之前的值会被覆盖掉
            x += lowbit(x);
        }
    }

    /**
     * 全局定义x为数组的第几位 没有第0位
     *
     * 查询前x位的前缀和
     * @param x
     * @return
     */
    public int query(int x) {
        int a = 0;

        while (x >0 ) {
            a += datas[x-1];
            x -= lowbit(x);
        }
        return a;
    }

}

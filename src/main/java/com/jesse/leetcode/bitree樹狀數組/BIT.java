package com.jesse.leetcode.bitree樹狀數組;

/**
 * up主 搭救 https://www.bilibili.com/video/BV1LW411e7jo?from=search&seid=1815853072203989825
 *
 * 复习专用：x的前缀和 = query(x) = datas[x的2进制数]+datas[x的2进制去掉最小的1]+datas[x的2进制去掉最小的1...]
 *         例如7的前缀和 = datas[7]+ datas[6] + datas[4]
 *              7 -> 111,6 -> 110, 4-> 100
 *
 *         所以我们可以理解为datas的7 管理 7,6,4
 *
 * 时间复杂度：
 *      update 和 query 都是logn
 * @author jesse hsj
 * @date 2020/6/9
 */
public class BIT {
    int[] datas;

    /**
     * 亮点操作
     * 目的是找出最小的1在哪一位
     * 例如 1100 最小的1就是最右边的1
     *
     *
     * -i代表i的补码
     * 正数的补码等于正数的反码+1
     *      例如：1100的补码等于 0011+1 = 0100
     *      1100&0100 得到了0100，肉眼可以看出1100最小的1在第三位，结果一样，得证！
     *      得到0100 我们可以通过+或者-得方式，得到管理的区域
     *
     * 这里有点干：
     * update时 通过+0100的方式 得到跟1100相关的区域
     * query时，通过-0100的方式，得到下一个需要加起来的区域
     */
    private int lowbit(int x) {
        //-x就是x的补码
        //例如 1100的补码等于 0011+1 = 0100
        //1100&0100 得到了0100，肉眼可以看出1100最小的1在第三位，结果一样，得证！
        return x & (-x);
    }

    public void update(int x, int val) {
        while (x <= datas.length) {
            datas[x - 1] += val; //这里必须是+  因为初始化时一个一个update的 不+的话 之前的值会被覆盖掉
            x += lowbit(x);
        }
    }

    /**
     * 全局定义x为数组的第几位 没有第0位 从1开始
     * 查询前x位的前缀和
     *
     * @param x
     * @return
     */
    public int query(int x) {
        int a = 0;

        while (x > 0) {
            a += datas[x - 1];
            x -= lowbit(x);
        }
        return a;
    }

}

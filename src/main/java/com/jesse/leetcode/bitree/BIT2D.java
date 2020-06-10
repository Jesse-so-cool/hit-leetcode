package com.jesse.leetcode.bitree;

/**
 * 二维数组的BIT
 *
 * @author jesse hsj
 * @date 2020/6/10 10:47
 */
public class BIT2D {

    int[][] bit ;

    int[][] datas;

    private int lowbit(int x) {
        return x&(-x);
    }
    public BIT2D(int[][] datas) {
        int m = datas.length;
        int n = datas[0].length;
        this.bit = new int[m+1][n+1];
        this.datas = datas;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i+1,j+1,datas[i][j]);
            }
        }
    }

    //直接赋值
    public void update2(int row,int col,int val) {

        update(row+1, col+1, val-datas[row][col]);
        datas[row][col] = val;
    }

    //add值
    public void update(int row,int col,int val) {
//        int delta = val - datas[row-1][col-1];
//        datas[row-1][col-1] = val;
        while (row <= datas.length) {
            int j = col;
            while (j <= datas[0].length) {
                bit[row][j] += val;

                j += lowbit(j);
            }

            row += lowbit(row);
        }

    }

    public int query(int row, int col) {
        int a = 0;

        while (row > 0) {
            int j = col;
            while (j > 0) {
                a += bit[row][j];

                j -= lowbit(j);
            }

            row -= lowbit(row);
        }

        return a;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return query(row2+1, col2+1) + query(row1, col1) - query(row1, col2+1) - query(row2+1, col1);
    }
}

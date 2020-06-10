package com.jesse.leetcode.bitree;

/**
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5],
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 *
 * @author jesse hsj
 * @date 2020/6/10 10:44
 */
public class RangeSumQuery2D {

    public static void main(String[] args) {
        int[][] datas = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        };


        BIT2D k = new BIT2D(datas);
        System.out.println(k.sumRegion(2, 1, 4, 3));
        k.update2(3,3,5);//答案应为8+5-1 = 12
        System.out.println(k.sumRegion(2, 1, 4, 3));

    }


}

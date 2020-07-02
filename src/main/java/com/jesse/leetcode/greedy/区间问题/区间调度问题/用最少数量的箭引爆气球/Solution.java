package com.jesse.leetcode.greedy.区间问题.区间调度问题.用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * https://gblobscdn.gitbook.com/assets%2F-LrtQOWSnDdXhp3kYN4k%2Fsync%2F06e34bd6a24f7e3a53e269204e227751e1dccc62.jpg?alt=media
 *
 * 解决区间问题的一般思路是先排序，然后观察规律。
 * leetcode 452
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @author jesse hsj
 * @date 2020/7/2 15:58
 */
public class Solution {
    public static void main(String[] args) {
        int[][] ints = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };
        System.out.println(new Solution().findMinArrowShots(ints));
    }

    //题目实际意义就是让找出 不重叠的数组数
    public int findMinArrowShots(int[][] points) {

        //以区间终点从小到大排序
        //https://gblobscdn.gitbook.com/assets%2F-LrtQOWSnDdXhp3kYN4k%2Fsync%2F06e34bd6a24f7e3a53e269204e227751e1dccc62.jpg?alt=media
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        //我们目的是找出最小 不重叠的数组数
        int res = 1;
        int end =  points[0][1];
        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            //找出区间不重叠的
            if (start > end) {
                res ++;
                end = points[i][1];
            }
        }
        return res;
    }
}

package com.jesse.leetcode.dp.拼多多.最少热量;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/8/2
 */
public class Solution {

    public static void main(String[] args) {
        int[][] lunch = {
                {9, 1},
                {4, 9},
                {3, 1},
                {2, 3},
                {6, 5}
        };
        int[][] dinner = {
                {9, 8}
        };
        System.out.println(new Gson().toJson(new Solution().least(lunch,dinner,9)));
    }

    public int least(int[][] lunch, int[][] dinner, int delicious) {
        if (delicious == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        List<Integer> temp = new ArrayList<>();
        //假设lunch只吃了一顿
        for (int i = 0; i < lunch.length; i++) {
            int[] o = lunch[i];
            if (o[1] >= delicious)
                min = Integer.min(min, o[0]);
            else {
                temp.add(i);
            }
        }
        //假设只吃了一顿dinner
        for (int i = 0; i < dinner.length; i++) {
            int[] o = dinner[i];
            if (o[1] >= delicious)
                min = Integer.min(min, o[0]);
            else {
                //两个都吃
                for (Integer in : temp) {
                    if (lunch[in][1] + o[1] >= delicious) {
                        min = Integer.min(min, lunch[in][0] + o[0]);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}

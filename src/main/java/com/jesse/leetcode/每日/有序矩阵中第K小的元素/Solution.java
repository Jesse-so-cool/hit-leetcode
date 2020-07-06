package com.jesse.leetcode.每日.有序矩阵中第K小的元素;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 * @author jesse hsj
 * @date 2020/7/2 10:27
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int k = 8;
        System.out.println(new Solution().kthSmallest(matrix,k));
    }

    public int kthSmallest(int[][] matrix, int k) {
        //队列存的值为new int[]{值,值所在的行,值所在的列}
        Queue<int[] > queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < matrix.length; i++) {
            queue.add(new int[]{matrix[i][0],i,0});
        }
        for (int i = 0; i < k-1; i++) {
            int[] poll = queue.poll();
            if (poll[2] < matrix.length-1)
                queue.offer(new int[]{matrix[poll[1]][poll[2]+1],poll[1],poll[2]+1});
        }

        return queue.poll()[0];
    }
}

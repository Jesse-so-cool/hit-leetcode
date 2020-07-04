package com.jesse.leetcode.dp.高楼扔鸡蛋;

/**
 * @author jesse hsj
 * @date 2020/7/3
 */
public class Solution2 {

    int[][] temp ;

    public int superEggDrop(int K, int N) {
        temp = new int[K+1][N+1];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = -1;
            }
        }
        return bsdp(K, N);
    }

    //在K个鸡蛋、N层的条件下，最坏情况下最少扔鸡蛋次数
    //超时
    private int dp(int K, int N) {
        if (K == 1)
            return N;
        if (N == 0)
            return 0;
        if (temp[K][N] != -1) {
            return temp[K][N];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int max = Integer.max(dp(K - 1, i - 1), dp(K, N - i)) + 1;//取摔坏和摔不坏的最坏结果
            res = Integer.min(res, max);
        }
        temp[K][N] = res;
        return res;
    }

    private int bsdp(int K, int N) {
        if (K == 1)
            return N;
        if (N == 0)
            return 0;
        if (temp[K][N] != -1) {
            return temp[K][N];
        }
        int low = 1;
        int high = N;

        int res = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low+high)/2;
            int broken = dp(K - 1, mid - 1);
            int notBroken = dp(K, N - mid);
            if (broken > notBroken) {
                high = mid - 1;
                res = Integer.min(res,broken+1);
            }else {
                low = mid + 1;
                res = Integer.min(res,notBroken+1);
            }
        }
        temp[K][N] = res;
        return res;
    }
}
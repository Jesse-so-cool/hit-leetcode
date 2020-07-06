package com.jesse.leetcode.dp.高楼扔鸡蛋;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 找出最坏情况下的F
 * <p>
 * https://leetcode-cn.com/problems/super-egg-drop/
 * leetcode 887
 *
 * @author jesse hsj
 * @date 2020/7/2
 */
public class Solution {


    //没做出来 考虑dp还是使用递归
    public int superEggDrop(int K, int N) {
        //定义dp[K][N]:存在K个鸡蛋，N个楼层可以选择的情况下，最坏情况最少扔几次鸡蛋才能找到F
        //状态 鸡蛋个数、楼层  这两个都会随着游戏进行改变 这就是状态的变化
        int[][] dp = new int[K + 1][N + 1];
        //选择 ： 从哪一层扔下去
        int res = N + 1;

        //base case dp[1][N] = N; dp[K][0] = 1
        for (int i = 0; i <= K; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= N; i++) {
            dp[1][i] = i;
        }
        for (int i = 0; i < K; i++) {
            for (int j = 0; j <= N; j++) {
                if (i - 1 < 0) {
                    dp[i][j] = dp[i][N - j];
                } else {
                    int broken = dp[i - 1][j - 1];
                    int notBroken = dp[i][N - j];
                    dp[i][j] = Integer.max(broken, notBroken);
                }
            }
        }

        return dp[K][N];
    }

}

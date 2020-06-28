package com.jesse.leetcode.BFSAndDFS.回溯算法.子集问题;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jesse hsj
 * @date 2020/6/20
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(nums));
        System.out.println(subsets.results.size());
    }

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int startIndex = 0;
        List<Integer> track = new ArrayList<>();
        backtrack(nums,startIndex,track);
        return results;
    }

    private void backtrack(int[] nums, int startIndex, List<Integer> track) {
        results.add(new ArrayList<>(track));

        for (int i = startIndex; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums,i+1, track);
            track.remove(track.size()-1);
        }
    }

}

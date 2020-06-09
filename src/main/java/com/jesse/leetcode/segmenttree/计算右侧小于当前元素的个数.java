package com.jesse.leetcode.segmenttree;

import com.google.gson.Gson;

import java.util.Arrays;

/**
 * 示例
 * 输入[5,2,6,1]
 * 输出[2,1,1,0]
 *
 * @author jesse hsj
 * @date 2020/6/9 11:55
 */
public class 计算右侧小于当前元素的个数 {

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        int[] ans = countSmaller(nums);

        System.out.println(new Gson().toJson(ans));
    }

    private static int[] countSmaller(int[] nums) {
        int[] sort = Arrays.copyOf(nums,nums.length);
        int[] ans = new int[nums.length];
        Arrays.sort(sort);

        final SegmentTreeNode tree = SegmentTreeNode.build(sort[0], sort[nums.length-1]);

        /**
         * 需要保证是右边的 所以只能通过从右至左的方式遍历 注释的代码是不管左右的 注释代码结果是[2,1,3,0]
         */
//        for (int i = 0; i < nums.length; i++) {
//            tree.insert(tree,nums[i],1);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            final int count = tree.count(tree, sort[0], nums[i]-1);
//            ans[i] = count;
//        }

        for (int i = nums.length-1; i >= 0; i--) {
            final int count = tree.count(tree, sort[0], nums[i]-1);
            tree.insert(tree,nums[i],1);
            ans[i] = count;
        }

        return ans;
    }

}

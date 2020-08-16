package com.jesse.leetcode.tree.最大二叉树;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/8/2
 */
public class Solution {
    public static void main(String[] args) {
            int[] nums = {1,1,1,2,2,3,3};
            System.out.println(new Gson().toJson(new Solution().constructMaximumBinaryTree(nums)));
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums,int low,int high) {
        if(low > high) return null;
        int index = low;
        for(int i=low;i<=high;i++){
            if(nums[index] < nums[i]) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums,low,index-1);
        root.right = helper(nums,index+1,high);
        return root;
    }


}

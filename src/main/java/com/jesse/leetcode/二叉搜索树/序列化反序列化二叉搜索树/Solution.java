package com.jesse.leetcode.二叉搜索树.序列化反序列化二叉搜索树;

import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/7/24 10:05
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] nums = {2,1};
        TreeNode t = TreeNode.create(nums);
        String s = new Solution().serialize(t);
        System.out.println(s);
        System.out.println(new Solution().deserialize(s));
    }

    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] nums = data.split(",");
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = Integer.parseInt(nums[i]);
        }
        return fucker(f, 0, nums.length - 1);
    }

    private TreeNode fucker(int[] nums, int low, int high) {
        if (low > high)
            return null;
        TreeNode t = new TreeNode(nums[low]);
        if (low == high) {
            return t;
        }
        int index = high + 1;
        for (int i = low; i <= high; i++) {
            if (nums[i] > nums[low]) {
                index = i;
                break;
            }
        }
        t.left = fucker(nums, low + 1, index - 1);
        t.right = fucker(nums, index, high);
        return t;
    }
}

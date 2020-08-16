package com.jesse.leetcode.tree.序列化;

import com.jesse.leetcode.entity.TreeNode;

import java.util.LinkedList;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2020/7/22 15:19
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {3, 1, 4, null, 2};
        TreeNode t = TreeNode.create(nums);
        System.out.println(new Solution().serialize(t));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        traverse(root, sb);
        return sb.toString();
    }

    void traverse(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#,");
        } else {
            sb.append(root.val + ",");
            traverse(root.left, sb);
            traverse(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : datas) {
            nodes.addLast(s);
        }

        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        String s = nodes.pollFirst();
        if (s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

}

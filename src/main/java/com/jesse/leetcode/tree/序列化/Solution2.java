package com.jesse.leetcode.tree.序列化;

import com.jesse.leetcode.entity.TreeNode;

import java.util.*;

/**
 * 迭代
 *
 * @author jesse hsj
 * @date 2020/7/22 15:19
 */
public class Solution2 {
    public static void main(String[] args) {
        Integer[] nums = {3, 1, 4, null, 2};
        TreeNode t = TreeNode.create(nums);
        System.out.println(new Solution2().serialize(t));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        traverse(root, sb);
        return sb.toString();
    }

    void traverse(TreeNode root, StringBuffer sb) {
        Stack<Object> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object o = stack.pop();
            if (o == null) {
                sb.append( "#,");
            } else if (o instanceof TreeNode) {
                TreeNode node = (TreeNode) o;
                stack.push(node.right);
                stack.push(node.left);
                stack.push(node.val);
            } else {
                sb.append(o + ",");
            }
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

    /**
     * 这里迭代不会写
     * @param nodes
     * @return
     */
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

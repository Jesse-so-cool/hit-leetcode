package com.jesse.leetcode.tree.N叉树的深度;

import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/7/30
 */
public class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for(Node t : root.children)
            max = Integer.max(max,maxDepth(t));
        return 1+max;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

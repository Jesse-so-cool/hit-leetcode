package com.jesse.leetcode.tree.N叉树的后序遍历;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jesse hsj
 * @date 2020/7/30
 */
public class Solution {

    public static void main(String[] args) {
        Node node = new Node(1);

        System.out.println(new Gson().toJson(new Solution().postorder(node)));
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack stack = new Stack();
        while (!stack.isEmpty()) {
            Object o = stack.pop();
            if (o instanceof Node) {
                Node n = (Node) o;
                int size = n.children.size();
                for (int i = size-1; i >= 0 ; i--)
                    stack.push(n.children.get(i));
                stack.push(n.val);
            } else {
                res.add((int) o);
            }
        }
        return res;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}

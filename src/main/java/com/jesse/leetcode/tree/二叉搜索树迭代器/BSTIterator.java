package com.jesse.leetcode.tree.二叉搜索树迭代器;

import com.jesse.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * @author jesse hsj
 * @date 2020/7/23 10:20
 */
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        init(root);
    }

    /**\
     * 采用迭代的方式来模拟中序遍历
     * @param root
     */
    private void init(TreeNode root) {
        while (root !=null){
            stack.push(root);
            root = root.left;
        }
    }

    //所有节点均只会入栈一次, 摊还下来, 每次next,只有一次入栈操作, 所以平均复杂度O(1)
    /** @return the next smallest number */
    public int next() {
        TreeNode t = stack.pop();
        if (t.right!=null){
            init(t.right);
        }
        return t.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }


}

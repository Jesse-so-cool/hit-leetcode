package com.jesse.leetcode.tree.另一个树的子树;

import com.jesse.leetcode.entity.TreeNode;

/**
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1  2
 * 返回 true
 *
 * @author jesse hsj
 * @date 2020/7/22 10:23
 */
public class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        return isSubTree2(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubTree2(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (s == null || t==null)
            return false;
        return (s.val == t.val) && isSubTree2(s.left, t.left) && isSubTree2(s.right, t.right);
    }


}

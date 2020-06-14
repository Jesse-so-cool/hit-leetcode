package com.jesse.leetcode.recursion.路径总和III;

import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/6/14
 */
public class Solution {

    int n = 0;

    public static void main(String[] args) {
        //Integer[] root = {10,5,-3,3,2,null,11,3,-2,null,1};
        Integer[] root = {1,-2,-3,1,3,-2,null,-1};
        //Integer[] root = {1,-2,-3,1,3,-2,null,-1};

        System.out.println(new Solution().pathSum(TreeNode.create(root), -1));
    }

    //算出root下 有几个符合要求的路径
    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }
        int k = 0;
        if (root.val == sum) {
            k = 1;
        }
        return k+pathSum(root.left,sum)+pathSum(root.right,sum)+pathSum2(root.left,sum-root.val)+pathSum2(root.right,sum-root.val);
    }

    //只包括以root节点开头的
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //自身就是所求的值
        int k = 0;
        if (root.val == sum) {
            k = 1;
        }
        return k + pathSum2(root.left,sum-root.val)+pathSum2(root.right,sum-root.val);
    }
}

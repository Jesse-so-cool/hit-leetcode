package com.jesse.leetcode.二叉搜索树.插入;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

/**
 * @author jesse hsj
 * @date 2020/8/6
 */
public class Solution {



    public static void main(String[] args) {
            Integer[] nums = {40,20,60,10,30,50,70};
            System.out.println(new Gson().toJson(new Solution().insertIntoBST(TreeNode.create(nums),25).serialize()));
    }
    boolean isFlag = false;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        inOrder(root,val);
        if(!isFlag){
            TreeNode t = new TreeNode(val);
            t.left = root;
            return t;
        }
        return root;
    }
    private void inOrder(TreeNode root, int val) {
        if(root == null)
            return;
        inOrder(root.left,val);
        if(root.val >= val && !isFlag){
            isFlag = true;
            TreeNode temp = root.left;
            root.left = new TreeNode(val);
            root.left.left = temp;
        }
        inOrder(root.right,val);
    }
}

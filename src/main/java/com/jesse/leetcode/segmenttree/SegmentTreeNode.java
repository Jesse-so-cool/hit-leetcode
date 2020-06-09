package com.jesse.leetcode.segmenttree;

/**
 * TODO
 *线段树，就是一种按照二叉树的形式存储数据的结构，每个节点保存的都是数组里某一段的总和。
 *
 * 适用于数据很多，而且需要频繁 <更新> 并 <求和>的操作。
 *
 * 时间复杂度 O(logn)。
 *
 * @author jesse hsj
 * @date 2020/6/9 11:02
 */
public class SegmentTreeNode {

    int start;
    int end;
    int count;

    SegmentTreeNode left;
    SegmentTreeNode right;

    public SegmentTreeNode(int _start, int _end){
        count = 0;
        start = _start;
        end = _end;
        left = null;
        right = null;
    }

    /**
     * 构建线段树
     */
    public static SegmentTreeNode build(int start, int end) {
        if (start>end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        if (start != end) {
            int mid = start+(end-start)/2;
            root.left = build(start,mid);
            root.right = build(mid+1,end);
        }
        return root;
    }
    public void insert(SegmentTreeNode root, int index, int val){
        if (root == null) {
            return;
        }

        if (root.end == root.start && root.start == index) {
            root.count += val;
            return;
        }
        int rootMid = root.start+(root.end-root.start)/2;
        if (index >= root.start && index <= rootMid) {
            insert(root.left,index,val);
        }else if (index > rootMid && index <= end){
            insert(root.right,index,val);
        }
        root.count = root.left.count + root.right.count;
        //root.count = (root.left==null?0:root.left.count) + (root.right==null?0:root.right.count);

    }

    public int count(SegmentTreeNode root, int start, int end){


        if (root == null) {
            return 0;
        }

        if (start > end) {
            return 0;
        }
        //区间 1 到 3 被完全包含在 1 到 5 之间，把该节点所统计好的数返回
        if (root.start == start && root.end == end) {
            return root.count;
        }



        int rootMid = root.start+(root.end-root.start)/2;
        int leftCount = 0, rightCount = 0;
        if (start <= rootMid) {
            if (rootMid < end) {
                leftCount = count(root.left,start,rootMid);
                rightCount = count(root.right,rootMid+1,end);
            }else {
                leftCount = count(root.left,start,end);
            }
        }else {
            rightCount = count(root.right,start,end);
        }
        return leftCount+rightCount;

    }
}

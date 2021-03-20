package com.jesse.leetcode.面经扣来的题.删除排序链表中的重复元素;


/**
 * @author jesse hsj
 * @date 2021/3/21
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        head.next = deleteDuplicates(head.next,head.val);
        return head;
    }

    private ListNode deleteDuplicates(ListNode next, int val) {
        if (next == null) return null;
        if (next.val == val) {
            return deleteDuplicates(next.next,next.val);
        }
        next.next = deleteDuplicates(next.next,next.val);
        return next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

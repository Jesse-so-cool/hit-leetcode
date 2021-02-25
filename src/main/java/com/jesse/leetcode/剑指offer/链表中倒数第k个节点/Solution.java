package com.jesse.leetcode.剑指offer.链表中倒数第k个节点;

import com.jesse.leetcode.linkedlist.ListNode;

/**
 * @author jesse hsj
 * @date 2020/12/18
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        //前后指针
        ListNode front = head;
        ListNode back = head;
        while (front != null) {
            front = front.next;
            if (k-- == 0) {
                break;
            }
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        return back;
    }

}

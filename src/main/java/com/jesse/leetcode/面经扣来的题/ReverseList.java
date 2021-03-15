package com.jesse.leetcode.面经扣来的题;

import com.jesse.leetcode.linkedlist.ListNode;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2021/3/15 16:57
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}

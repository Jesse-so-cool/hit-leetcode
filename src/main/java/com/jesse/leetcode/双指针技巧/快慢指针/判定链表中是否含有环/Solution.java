package com.jesse.leetcode.双指针技巧.快慢指针.判定链表中是否含有环;

import com.jesse.leetcode.linkedlist.ListNode;

/**
 * @author jesse hsj
 * @date 2020/6/22 10:59
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode fast,slow;
        fast = slow = head;

        while (fast != null && slow != null) {
            try {
                fast = fast.next.next;
                slow = slow.next;
            }catch (NullPointerException e) {
                return false;
            }

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }


}

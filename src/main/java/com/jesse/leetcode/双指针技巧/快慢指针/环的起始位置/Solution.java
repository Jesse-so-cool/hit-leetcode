package com.jesse.leetcode.双指针技巧.快慢指针.环的起始位置;

import com.jesse.leetcode.linkedlist.ListNode;

/**
 * 已知链表中含有环，返回这个环的起始位置
 *
 * @author jesse hsj
 * @date 2020/6/22 11:54
 */
public class Solution {

    //数学问题
    // 假设k是起点到环起始位置的距离，相遇位置和起始位置相差m
    // 因为是找circle的时候是两倍速 所以fast是走多了一圈 总共是slow走了k+m fast走了2（k+m）
    // 此时我们如果在相遇后，将fast = head，相同速度走一遍，相遇的点就是circle起始点
    public ListNode detectCycle(ListNode head) {
        ListNode fast;
        ListNode slow;
        fast = slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

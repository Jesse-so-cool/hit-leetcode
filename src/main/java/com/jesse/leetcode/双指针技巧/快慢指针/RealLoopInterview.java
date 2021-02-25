package com.jesse.leetcode.双指针技巧.快慢指针;

import com.jesse.leetcode.linkedlist.ListNode;

/**
 * @author jesse hsj
 * @date 2021/2/24
 */
public class RealLoopInterview {
    /**
     * 如何判断两个无环单链表有没有交叉点
     * 如何判断两个有环单链表有没有交叉点
     * 如何判断一个单链表有没有环, 并找出入环点
     *
     * 首先我们先写一个函数用来 判断一个单向链表是否有环，如果有则返回入环节点，如果没有返回null.
     */

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

    /**
     * 如何判断两个无环单链表有没有交叉点
     * 把链表head1尾结点链接到head2的头指针，然后判断有没有环
     */
    public boolean solute1(ListNode node1, ListNode node2) {
        ListNode temp = node1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node2;

        return detectCycle(node1) != null;
    }

    /**
     * 如何判断两个有环单链表有没有交叉点
     *      1. 入环节点在同一个节点：那么查找第一个相交节点的方法就和无环链表相交节点的查询方式一样了，只不过是终止点由null变成了loop(入环节点)
     *      2. 入环节点不在同一个节点：那么就从第一个入环节点loop1开始遍历，如果遇到了第二个入环节点loop2，那么说明第一个节点为目标节点，如果没有遇到，那说明这两个链表都是有环单向链表，但是不相交！返回null。
     */
    public boolean solute2(ListNode node1, ListNode node2) {
        ListNode loop1 = detectCycle(node1);
        ListNode loop2 = detectCycle(node2);
        if (loop1 == loop2) {
            //入环节点在同一个节点
            return true;
        } else {
            //入环节点不在同一个节点：
            //此时便利其中一个loop 出现loop中某个节点等于loop2即可
            ListNode temp = loop1.next;
            while (loop1 != temp) {
                if (temp == loop2) return true;
                temp = temp.next;
            }
            return false;
        }
    }

    /**
     * 如何判断一个单链表有没有环, 并找出入环点
     * @return
     */
    public ListNode solute3(ListNode node) {
        return detectCycle(node);
    }




}

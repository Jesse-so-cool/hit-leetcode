package com.jesse.leetcode.剑指offer.反转链表;

import com.jesse.leetcode.linkedlist.ListNode;

/**
 * @author jesse hsj
 * @date 2020/12/18
 */
public class Solution {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        ListNode third = new ListNode(3);
        first.next.next = third;




        new Solution().reverseList(first);
    }

    public ListNode reverseList(ListNode head) {
//        Stack<ListNode> stack = new Stack<>();
//        while(head != null && head.next != null){
//            stack.push(head);
//            head = head.next;
//        }
//        ListNode curr = head;
//        while(!stack.isEmpty()){
//            curr.next = stack.pop();
//            curr = curr.next;
//        }
//        curr.next = null;
//        return head;
        //todo 指针问题 不太懂


        //双指针
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}

package com.jesse.leetcode.linkedlist;

/**
 * K个数组反转
 * @author jesse hsj
 * @date 2020/6/7
 */
public class KInvert {

    public static void main(String[] args) {
        Integer[] datas = {1,2,3,4,5,6,7};
        ListNode listNode = ListNode.create(datas);

        ListNode node = kInvert(listNode,3);
        ListNode.print(node);

    }

    private static ListNode kInvert(ListNode listNode, int k) {
        if (listNode == null) {
            return null;
        }

        ListNode prev,curr,next;
        prev = null;
        curr = listNode;

        while (curr != null && k-- >0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode.add(prev,curr);

        return prev;
    }

}

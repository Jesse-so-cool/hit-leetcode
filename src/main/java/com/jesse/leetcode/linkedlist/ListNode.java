package com.jesse.leetcode.linkedlist;

/**
 * @author jesse hsj
 * @date 2020/6/7
 */
public class ListNode<T> {

    public T data;

    public ListNode next;

    public ListNode(T data) {
        this.data = data;
    }
    public static void add(ListNode node, Integer data) {
        if (node == null) {
            throw new RuntimeException();
        }
        if (node.next != null) {
            add(node.next,data);
        }else {
            node.next = new ListNode(data);
        }
    }

    public void add(T data) {
        if (this.next != null) {
            this.next.add(data);
        }else {
            this.next = new ListNode(data);
        }
    }

    public static void add(ListNode node1, ListNode node2) {
        if (node1 == null) {
            throw new RuntimeException();
        }
        while (node1.next != null) {
            node1 = node1.next;
        }
        node1.next = node2;
    }
    public static ListNode create(Integer datas[]) {
        ListNode head = new ListNode(null);
        for (Integer data : datas) {
            add(head,data);
        }
        return head.next;
    }

    public static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            System.out.print(" ");
            curr = curr.next;
        }
    }
}

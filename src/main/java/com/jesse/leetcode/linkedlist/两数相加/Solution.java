package com.jesse.leetcode.linkedlist.两数相加;


import com.jesse.leetcode.linkedlist.ListNode;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2021/3/12 13:48
 */
class Solution {
//    public static void main(String[] args) {
//        ListNode listNode = new ListNode(9);
//        ListNode next = new ListNode(9);
//        ListNode nenext = new ListNode(9);
//        listNode.next = next;
//        next.next = nenext;
//
//        ListNode listNode1 = new ListNode(9);
//        ListNode next1 = new ListNode(9);
//        //ListNode nenext1 = new ListNode(4);
//        listNode1.next = next1;
//        //next1.next = nenext1;
//
//        ListNode node = new Solution().addTwoNumbers(listNode, listNode1);
//        while (node!=null){
//            System.out.println(node.val);
//            node = node.next;
//        }
//
//
//    }

    ListNode res = new ListNode();

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        addTwoNumbers(l1,l2,0,res);
        return res.next;
    }

    /**
     * @param node1 正在计算的节点
     * @param node2 正在计算的节点
     * @param i 进数
     * @param node node.next = 计算后的node
     */
    private void addTwoNumbers(ListNode node1, ListNode node2, int i, ListNode node) {
        if (node1 == null && node2 == null){
            if (i == 0) {
                return;
            }else {
                node.next = new ListNode(i);
            }
        }
        int node1Val = node1 == null?0:node1.val;
        int node2Val = node2 == null?0:node2.val;
        int value = node1Val + node2Val + i;
        ListNode temp = new ListNode(value % 10);
        node.next = temp;
        //node.val = value % 10;
        addTwoNumbers(node1 == null?null:node1.next,node2 == null?null:node2.next,value/10,temp);
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

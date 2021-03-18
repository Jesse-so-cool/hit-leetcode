package com.jesse.leetcode.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目重点是cache 必须有顺序之分，以区分最近使用的和久未使用的数据；
 * 所以将value放在双向链表中
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(Thread.currentThread().getName());

    }

    //小贴士
    //在双向链表的实现中，使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
    class DLinkedNode {
        public int key, val;
        public DLinkedNode next, prev;
        public DLinkedNode() {
        }
        public DLinkedNode(int k, int v) {
            this.key = k;
            this.val = v;
        }

    }
    private DLinkedNode head, tail;
    private int size;
    private int capacity;
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        DLinkedNode dLinkedNode = cache.get(key);
        int val = dLinkedNode.val;

        remove(dLinkedNode);
        addFirst(dLinkedNode);
        return val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key,newNode);
            addFirst(newNode);
            size++;
            if (size > capacity) {
                DLinkedNode dLinkedNode = removeLast();
                cache.remove(dLinkedNode.key);
                --size;
            }

        }else {
            node.val = value;
            remove(node);
            addFirst(node);
        }
    }

    // 在链表头部添加节点 x，时间 O(1)
    private void addFirst(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    private void remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 删除链表中最后一个节点，并返回该节点，时间 O(1)
    private DLinkedNode removeLast(){

        DLinkedNode prev = tail.prev;
        remove(prev);
        return prev;
    }

    // 返回链表长度，时间 O(1)
    public int size(){
        return size;
    }
}

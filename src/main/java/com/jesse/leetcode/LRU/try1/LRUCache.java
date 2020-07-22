package com.jesse.leetcode.LRU.try1;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目重点是cache 必须有顺序之分，以区分最近使用的和久未使用的数据；
 * 所以将value放在双向链表中
 */
public class LRUCache {


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
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
        moveNodeToHead(dLinkedNode);
        return dLinkedNode.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkedNode dLinkedNode = cache.get(key);
            moveNodeToHead(dLinkedNode);
            dLinkedNode.val = value;
        } else {
            if (size == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
                size--;
            }
            DLinkedNode dLinkedNode = new DLinkedNode(key, value);
            cache.put(key, dLinkedNode);
            addFirst(dLinkedNode);
            size++;
        }
    }

    private void moveNodeToHead(DLinkedNode dLinkedNode) {
        remove(dLinkedNode);
        addFirst(dLinkedNode);
    }

    private void addFirst(DLinkedNode dLinkedNode) {
        dLinkedNode.next = head.next;
        dLinkedNode.prev = head;

        head.next.prev = dLinkedNode;
        head.next = dLinkedNode;
    }

    private void remove(DLinkedNode dLinkedNode) {
        dLinkedNode.prev.next = dLinkedNode.next;
        dLinkedNode.next.prev = dLinkedNode.prev;
    }


    // 返回链表长度，时间 O(1)
    public int size() {
        return size;
    }
}

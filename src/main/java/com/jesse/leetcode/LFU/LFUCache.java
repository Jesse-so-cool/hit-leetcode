package com.jesse.leetcode.LFU;

import java.util.HashMap;
import java.util.Map;

/**
 * LFU -> 对应原理图
 * @author jesse hsj
 * @date 2021/3/15 16:36
 */
public class LFUCache {

    public static void main(String[] args) {
        LFUCache lruCache = new LFUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);//2被淘汰
        System.out.println(lruCache.get(2));//-1
        System.out.println(lruCache.get(3));//freq2 1,3
        lruCache.put(4, 4);//淘汰1
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    int capacity;
    Map<Integer, Node<Integer, Integer>> cache = new HashMap<>();
    Map<Integer, DoubleNodeList> frequentMap = new HashMap<>();
    int minFrequent;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (cache.containsKey(key)) {
            Node<Integer, Integer> node = cache.get(key);

            clearOldFreqList(node);
            node.freq++;

            joinNewFreqList(node);

            return node.value;
        } else {
            return -1;
        }
    }

    private void joinNewFreqList(Node<Integer, Integer> node) {
        DoubleNodeList doubleNodeList;
        //加入新的freq链表
        if (frequentMap.containsKey(node.freq)) {
            doubleNodeList = frequentMap.get(node.freq);
        } else {
            doubleNodeList = new DoubleNodeList();
        }
        node.prev = doubleNodeList.head;
        node.next = doubleNodeList.head.next;
        doubleNodeList.head.next.prev = node;
        doubleNodeList.head.next = node;
        doubleNodeList.count++;
        frequentMap.put(node.freq, doubleNodeList);
    }

    private void clearOldFreqList(Node<Integer, Integer> node) {
        //清理掉原来的链表
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        frequentMap.get(node.freq).count--;

        //修改minfreq
        if (node.freq == minFrequent && frequentMap.get(node.freq).count == 0) {
            minFrequent++;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node<Integer, Integer> node = cache.get(key);
            node.value = value;
            clearOldFreqList(node);
            node.freq++;
            joinNewFreqList(node);

        } else {
            if (cache.size() == capacity) {
                removeLFU();
            }
            Node<Integer, Integer> node = new Node<>(key, value);


            cache.put(key, node);
            joinNewFreqList(node);
            minFrequent = 1;
        }
    }

    private void removeLFU() {
        DoubleNodeList nodeList = frequentMap.get(minFrequent);
        if (nodeList.count == 1) {
            cache.remove(nodeList.tail.prev.key);
            frequentMap.remove(minFrequent);
        } else {
            cache.remove(nodeList.tail.prev.key);
            nodeList.tail.prev.prev.next = nodeList.tail;
            nodeList.tail.prev = nodeList.tail.prev.prev;
            nodeList.count--;
        }
    }

    private class Node<K, V> {
        K key;
        V value;
        int freq = 1;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    public class DoubleNodeList {
        int count = 0;
        Node head;
        Node tail;

        public DoubleNodeList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
    }


}

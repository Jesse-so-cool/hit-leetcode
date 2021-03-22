package com.jesse.leetcode.LRU.try12;

import com.jesse.leetcode.LRU.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jesse hsj
 * @date 2021/3/6
 */
public class LRUCacheSuc {

    public static void main(String[] args) {
        LRUCacheSuc lruCache = new LRUCacheSuc(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    int capacity;
    Map<Integer,Node<Integer,Integer>> cache = new HashMap<>();
    Node<Integer,Integer> head,tail;

    public LRUCacheSuc(int capacity) {
        head = new Node<Integer, Integer>();
        tail = new Node<Integer, Integer>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            addToHead(key);
            return cache.get(key).value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            cache.put(key,new Node(key,value));
        }else {
            cache.put(key,new Node(key,value));
            if (capacity < cache.size()){
                removeTail();
            }
        }
        addToHead(key);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeTail() {
        tail.prev.prev.next = tail;
        Integer key = tail.prev.key;
        cache.remove(key);
    }

    private void addToHead(int key) {
        Node<Integer, Integer> node = cache.get(key);
        Node<Integer, Integer> next = head.next;
        node.prev = head;
        node.next = next;
        head.next = node;
        next.prev = node;
    }

    private class Node<K, V> {
        K key;
        V value;
        Node<K,V> prev;
        Node<K,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}

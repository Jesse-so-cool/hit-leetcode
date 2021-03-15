package com.jesse.leetcode.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * put会更新node的时间
 *
 * @author jesse hsj
 * @date 2021/3/15 16:36
 */
public class LRUWithExpired {

    int capacity;
    Map<Integer,Node<Integer,Integer>> cache = new HashMap<>();
    Node<Integer,Integer> head,tail;//辅助指针 实际头为head.next 尾为tail.prev
    long expired;

    public LRUWithExpired(int capacity,long expired) {
        head = new Node<Integer, Integer>();
        tail = new Node<Integer, Integer>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        this.expired = expired;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node<Integer, Integer> node = cache.get(key);
            if (System.currentTimeMillis() - node.creatimestamp > expired){
                remove(key);
                return -1;
            }
            remove(key);
            addToHead(key);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(key);
            cache.put(key,new Node(key,value));
        }else {
            cache.put(key,new Node(key,value));
            if (capacity < cache.size()){
                removeTail();
            }
        }
        addToHead(key);
    }

    /**
     * 删掉某个节点
     * @param key
     */
    private void remove(Integer key) {
        Node<Integer, Integer> node = cache.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //去除尾节点
    private void removeTail() {
        tail.prev.prev.next = tail;
        Integer key = tail.prev.key;
        cache.remove(key);
    }

    //把某个节点加到头节点
    private void addToHead(int key) {
        Node<Integer, Integer> node = cache.get(key);
        node.creatimestamp = System.currentTimeMillis();

        Node<Integer, Integer> next = head.next;
        node.prev = head;
        node.next = next;
        head.next = node;
        next.prev = node;
    }

    private class Node<K, V> {
        K key;
        V value;
        long creatimestamp = System.currentTimeMillis();
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

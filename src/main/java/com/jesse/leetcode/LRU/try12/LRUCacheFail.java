package com.jesse.leetcode.LRU.try12;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 题目重点是cache 必须有顺序之分，以区分最近使用的和久未使用的数据；
 * 所以将value放在双向链表中
 */
public class LRUCacheFail {

    Map<Integer, Integer> cache = new HashMap<>();
    int capacity;
    LinkedList<Integer> queue = new LinkedList();

    public LRUCacheFail(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(key);//移除队列中的当前节点，但是这里做不到O(1)，所以不能这么干了
            addToHead(key);//把当前节点移动到头部
            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(key);//移除队列中的当前节点，但是这里做不到O(1)，所以不能这么干了
            cache.put(key, value);
        } else {
            cache.put(key, value);
            if (capacity < cache.size()) {
                removeTail();
            }
        }
        addToHead(key);
    }

    private void removeTail() {

    }

    private void addToHead(int key) {
    }

    private void remove(Integer key) {
        //这里做不到O(1)，所以不能这么干了
    }
}
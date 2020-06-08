package com.jesse.leetcode.heap;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.*;

/**
 * 优先队列问题
 * 优先队列的本质是一个二叉堆结构。
 * <p>
 * 关键词 “前K个” 我们要联想到优先队列
 *
 * @author jesse hsj
 * @date 2020/6/8 16:53
 */
public class 前K个高频元素 {

    public static void main(String[] args) {
        int[] datas = {1, 2, 3, 1, 2, 3, 4, 5, 6, 1, 2, 4, 6, 2, 3, 4, 5, 6, 2, 2, 2, 1, 1, 1};

        final List list = topKFrequent(datas, 3);

        System.out.println();
    }

    public static List topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(map)) {
                map.put(num, map.get(num) + 1)
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2); //构建的是最大堆
            }
        });

        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        final Iterator<Integer> iterator = priorityQueue.iterator();
        if (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}

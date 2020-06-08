package com.jesse.leetcode.deque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 算法复杂度分析
 * 读者可能疑惑，push 操作中含有 while 循环，时间复杂度不是 O(1) 呀，那么本算法的时间复杂度应该不是线性时间吧？
 *
 * 单独看 push 操作的复杂度确实不是 O(1)，但是算法整体的复杂度依然是 O(N)线性时间。
 * 要这样想，nums 中的每个元素最多被 push_back 和 pop_back 一次，没有任何多余操作，所以整体的复杂度还是O(N)。
 * 空间复杂度就很简单了，就是窗口的大小 O(k)。
 * @author jesse hsj
 * @date 2020/6/7
 */
public class 滑动窗口最大值 {

    public static void main(String[] args) {
        int[] datas = {1,3,1,-3,5,3,6,7};
        Object[] ans = max(datas,3);
        Arrays.stream(ans).forEach(System.out::println);
    }

    private static Object[] max(int[] datas, int k) {

        MonotonicDeque monotonicDeque = new MonotonicDeque();
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < datas.length; i++) {

            if (i < k-1) {
                monotonicDeque.push(datas[i]);
            }else {
                monotonicDeque.push(datas[i]);
                ls.add(monotonicDeque.max());
                monotonicDeque.pop(datas[i-k+1]);
            }

        }
        return ls.stream().toArray();

    }



}

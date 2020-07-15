package com.jesse.leetcode.每日.两个数组的交集II;

import com.google.gson.Gson;

import java.util.*;

/**
 * @author jesse hsj
 * @date 2020/7/13
 */
public class Solution {

    public static void main(String[] args) {
        int nums1[] = {54,93,21,73,84,60,18,62,59,89,83,89,25,39,41,55,78,27,65,82,94,61,12,38,76,5,35,6,51,48,61,0,47,60,84,9,13,28,38,21,55,37,4,67,64,86,45,33,41};
        int nums2[] = {17,17,87,98,18,53,2,69,74,73,20,85,59,89,84,91,84,34,44,48,20,42,68,84,8,54,66,62,69,52,67,27,87,49,92,14,92,53,22,90,60,14,8,71,0,61,94,1,22,84,10,55,55,60,98,76,27,35,84,28,4,2,9,44,86,12,17,89,35,68,17,41,21,65,59,86,42,53,0,33,80,20};
        System.out.println(new Gson().toJson(new Solution().intersect(nums1, nums2)));
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1==0 || length2 == 0){
            return new int[]{};
        }
        List<Integer> li = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < length1; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < length2; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) == 1) {
                    map.remove(nums2[i]);
                }else {
                    map.put(nums1[i],map.get(nums1[i])-1);
                }
                li.add(nums2[i]);
            }
        }
        int[] i = new int[li.size()];
        for (int i1 = 0; i1 < li.size(); i1++) {
            i[i1] = li.get(i1);
        }
        return i;
    }
}

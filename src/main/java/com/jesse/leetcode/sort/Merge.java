package com.jesse.leetcode.sort;

import com.google.gson.Gson;

import java.util.Arrays;

/**
 * 空间复杂度
 *      由于合并 n 个元素需要分配一个大小为 n 的额外数组，合并完成之后，这个数组的空间就会被释放，所以算法的空间复杂度就是 O(n)。归并排序也是稳定的排序算法。
 * 时间复杂度
 *      归并算法是一个不断递归的过程。
 *      不断地把一个规模为 n 的问题分解成规模为 n/2 的问题，一直分解到规模大小为 1。
 *      如果 n 等于 2，只需要分一次；如果 n 等于 4，需要分 2 次。这里的次数是按照规模大小的变化分类的。
 *      以此类推，对于规模为 n 的问题，一共要进行 log(n) 层的大小切分。在每一层里，我们都要进行合并，所涉及到的元素其实就是数组里的所有元素，
 *      因此，每一层的合并复杂度都是 O(n)，所以整体的复杂度就是 O(nlogn)。
 *
 * 归并算法的思想很重要，其中对两个有序数组合并的操作，
 * 在很多面试题里都有用到 ,一定要把这个算法练熟。
 * @author jesse hsj
 * @date 2020/6/11 10:42
 */
@SuppressWarnings("ALL")
public class Merge implements Sort {

    public static void main(String[] args) {
        int nums[] = {2, 1, 7, 9, 5, 8};
        new Merge().sort(nums);
        System.out.println(new Gson().toJson(nums));
    }

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    //T(N) = 2T(N/2)+O(N)
    private void sort(int[] nums, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    //这里如果不理解 可以看看merge.md
    private void merge(int[] nums, int low, int mid, int high) {
        int temp[] = Arrays.copyOf(nums, nums.length);
        int left = low;
        int right = mid + 1;
        for (int i = low; i <= high; i++) {
            if (right > high) {
                nums[i] = temp[left++];
                continue;
            }
            if (left > mid) {
                nums[i] = temp[right++];
                continue;
            }
            if (temp[left] > temp[right]) {
                nums[i] = temp[right++];
            }else if (temp[left] <= temp[right]){
                nums[i] = temp[left++];
            }
        }
    }


}

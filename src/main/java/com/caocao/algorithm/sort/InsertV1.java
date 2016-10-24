package com.caocao.algorithm.sort;

import java.util.Arrays;

/**
 * Created by m on 16-10-18.
 * 分类 ------------- 内部比较排序
 * 数据结构 ---------- 数组
 * 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
 * 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
 * 平均时间复杂度 ---- O(n^2)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 稳定
 */
public class InsertV1 {
    public static void main(String[] args) {
        int[] a = {6, 8, 2, 4, 9, 1, 0, 4};
        System.out.println(Arrays.toString(a));
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int t = a[i];
            int j;
            for (j = i - 1; j >= 0 && a[j] > t; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = t;
        }
    }
}

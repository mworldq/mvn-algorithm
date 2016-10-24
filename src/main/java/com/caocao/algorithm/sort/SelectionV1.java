package com.caocao.algorithm.sort;

import java.util.Arrays;

/**
 * Created by m on 16-10-18.
    分类 -------------- 内部比较排序
    数据结构 ---------- 数组
    最差时间复杂度 ---- O(n^2)
    最优时间复杂度 ---- O(n^2)
    平均时间复杂度 ---- O(n^2)
    所需辅助空间 ------ O(1)
    稳定性 ------------ 不稳定
 */

public class SelectionV1 {

    public static void main(String[] args) {
        int[] a = {6, 8, 2, 4, 9, 1, 0, 4};
        System.out.println(Arrays.toString(a));
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void selectionSort(int a[]) {
        int minVal;
        int minIndex;
        for (int i = 0; i < a.length - 1; i++) {
            minVal = a[i];
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < minVal) {
                    minVal = a[j];
                    minIndex = j;
                }
            }
            if (minVal != a[i] && minIndex != i) {
                a[minIndex] = a[i];
                a[i] = minVal;
            }
        }
    }
}
package com.caocao.algorithm.sort;

import java.util.Arrays;

/**
 * Created by m on 16-10-18.
    分类 -------------- 内部比较排序
    数据结构 ---------- 数组
    最差时间复杂度 ---- O(nlogn)
    最优时间复杂度 ---- O(nlogn)
    平均时间复杂度 ---- O(nlogn)
    所需辅助空间 ------ O(n)
    稳定性 ------------ 稳定
 */
public class MergeV1 {


    public static void main(String[] args) {
        int[] a = {6, 8, 2, 4, 9, 1, 0, 4};
        System.out.println(Arrays.toString(a));
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void mergeSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    static void sort(int data[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            System.out.println("mid:" + mid);
            sort(data, start, mid);
            sort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    static void merge(int data[], int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (data[i] < data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = data[i++];
        }
        while (j <= end) {
            temp[k++] = data[j++];
        }

        for (k = 0, i = start; k < temp.length; k++, i++) {
            data[i] = temp[k];
        }
    }
}

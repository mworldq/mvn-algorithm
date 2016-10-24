package com.caocao.algorithm.sort;

/**
 * Created by m on 16-10-17.
    分类 ------------ 内部比较排序
    数据结构 --------- 数组
    最差时间复杂度 ---- O(n^2),待排序的元素有序时为最差情况,并不多见
    最优时间复杂度 ---- O(nlogn)
    平均时间复杂度 ---- O(nlogn)
    所需辅助空间 ------ O(logn)～O(n),主要是递归造成的栈空间的使用(用来保存left和right等局部变量),取决于递归树的深度
                    一般为O(logn),最差为O(n)（基本有序的情况）
    稳定性 ---------- 不稳定
 */

public class QuickV1 {


    public static void main(String args[]) {
        QuickV1 q = new QuickV1();
        int[] a = {49, 38, 65, 12, 45, 5, 33};
        q.quickSort(a);
    }

    public void quickSort(int[] arrays) {
        if (null == arrays) {
            System.out.println("input error!");
            return;
        }
        _quickSort(arrays, 0, arrays.length - 1);
    }

    private void _quickSort(int[] arrays, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start;
        int j = end;
        int value = arrays[i];
        boolean flag = true;
        while (i != j) {
            if (flag) {
                if (value > arrays[j]) {
                    swap(arrays, i, j);
                    flag = false;
                } else {
                    j--;
                }
            } else {
                if (value < arrays[i]) {
                    swap(arrays, i, j);
                    flag = true;
                } else {
                    i++;
                }
            }
        }
        snp(arrays);
        _quickSort(arrays, start, j - 1);
        _quickSort(arrays, i + 1, end);

    }

    public void snp(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }

    private void swap(int[] arrays, int i, int j) {
        int temp;
        temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

}
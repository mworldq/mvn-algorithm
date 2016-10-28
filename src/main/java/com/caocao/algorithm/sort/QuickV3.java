package com.caocao.algorithm.sort;

import java.util.Arrays;
import java.util.Iterator;

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

public class QuickV3 {
    public static void main(String[] args){
        int[] a = {6,8,2,4,9,1,0,4};
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    static void quickSort (int[] a, int l, int r){
        int i = l, j=r, x = a[i];
        if(i < j) {
            while (i <= j) {
                while (i < j && a[j] >= x) {
                    j--;
                }
                a[i++] = a[j];

                while (i < j && a[i] < x) {
                    i++;
                }
                a[j] = a[i];
                j--;
            }
            a[i] = x;
            System.out.println(Arrays.toString(a));
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r - 1);
        }
    }
}

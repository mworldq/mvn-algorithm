package com.caocao.algorithm.sort;

import java.util.Arrays;

/**
 * Created by m on 16-10-18.
  分类 -------------- 内部比较排序
  数据结构 ---------- 数组
  最差时间复杂度 ---- 根据步长序列的不同而不同。已知最好的为O(n(logn)^2)
  最优时间复杂度 ---- O(n)
  平均时间复杂度 ---- 根据步长序列的不同而不同。
  所需辅助空间 ------ O(1)
  稳定性 ------------ 不稳定
 */
public class ShellV1 {
    public static void main(String[] args) {
        int[] a = {6, 8, 2, 4, 9, 1, 0, 4};
        System.out.println(Arrays.toString(a));
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void shellSort(int[] a) {
        int gap = a.length / 2;
        boolean flag = true;
        while (gap > 1 || flag) {
            flag = false;
            for (int i = 0; i + gap < a.length; i++)
                if (a[i] > a[i + gap]) {
                    int tmp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = tmp;
                    flag = true;
                }
            if (gap > 1)
                gap /= 2;
        }
    }
}

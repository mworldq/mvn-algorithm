package com.caocao.algorithm.sort;

import java.util.Arrays;

/**
 * Created by m on 16-10-18. -- 二分插入排序
 * 分类 ------------- 内部比较排序
 * 数据结构 ---------- 数组
 * 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
 * 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
 * 平均时间复杂度 ---- O(n^2)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 稳定
 */
public class InsertV2 {
    public static void main(String[] args) {
        int[] a = {6, 8, 2, 4, 9, 1, 0, 4};
        System.out.println(Arrays.toString(a));
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void insertSort(int[] a) {
        int i, j, get, left, right, middle;

        for (i = 1; i < a.length; i++)                 // 类似抓扑克牌排序
        {
            get = a[i];                         // 右手抓到一张扑克牌
            left = 0;                           // 拿在左手上的牌总是排序好的,所以可以用二分法
            right = i - 1;                      // 手牌左右边界进行初始化
            while (left <= right)               // 采用二分法定位新牌的位置
            {
                middle = (left + right) / 2;
                if (a[middle] > get)
                    right = middle - 1;
                else
                    left = middle + 1;
            }

            for (j = i - 1; j >= left; j--)    // 将欲插入新牌位置右边的牌整体向右移动一个单位
            {
                a[j + 1] = a[j];
            }

            a[left] = get;                    // 将抓到的牌插入手牌
        }
    }
}

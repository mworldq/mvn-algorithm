package com.caocao.algorithm.sort;

import java.util.Arrays;

/**
 * Created by m on 16-10-18.
 * 分类 -------------- 内部比较排序
 * 数据结构 ---------- 数组
 * 最差时间复杂度 ---- O(nlogn)
 * 最优时间复杂度 ---- O(nlogn)
 * 平均时间复杂度 ---- O(nlogn)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 不稳定
 */
public class HeapsortV1 {
    public static void main(String[] args) {
        int[] a = {6, 8, 2, 4, 9, 1, 0, 4};
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));

    }

    static void heapSort(int[] a) {
        buildMaxHeap(a);
        for (int i = a.length; i > 1; i--) {
            int tmp = a[0];
            a[0] = a[i - 1];
            a[i - 1] = tmp;

            shiftHeap(a, 1, i - 1);
        }
    }

    static void buildMaxHeap(int[] a) {
        for (int i = a.length / 2; i > 0; i--) {
            shiftHeap(a, i, a.length);
        }
    }

    static void shiftHeap(int[] a, int parentNodeIndex, int heapSize) {
        // 最大节点索引
        int largestNodeIndex = parentNodeIndex;
        // 左子节点索引
        int leftChildNodeIndex = parentNodeIndex * 2;
        // 右子节点索引
        int rightChildNodeIndex = parentNodeIndex * 2 + 1;

        // 如果左子节点大于父节点，则将左子节点作为最大节点
        if (leftChildNodeIndex <= heapSize && a[leftChildNodeIndex - 1] > a[parentNodeIndex - 1]) {
            largestNodeIndex = leftChildNodeIndex;
        }

        // 如果右子节点比最大节点还大，那么最大节点应该是右子节点
        if (rightChildNodeIndex <= heapSize && a[rightChildNodeIndex - 1] > a[largestNodeIndex - 1]) {
            largestNodeIndex = rightChildNodeIndex;
        }

        // 最后，如果最大节点和父节点不一致，则交换他们的值
        if (largestNodeIndex != parentNodeIndex) {
            int tmp = a[parentNodeIndex - 1];
            a[parentNodeIndex - 1] = a[largestNodeIndex - 1];
            a[largestNodeIndex - 1] = tmp;

            // 交换完父节点和子节点的值，对换了值的子节点检查是否符合最大堆的特性
            shiftHeap(a, largestNodeIndex, heapSize);
        }
    }
}

package com.caocao.algorithm.sort;

import java.util.Arrays;

/**
 * Created by m on 16-10-24.
 */
public class HeapsortV2 {

    public static void main(String[] args) {
        int[] a = {6, 8, 2, 4, 9, 1, 0, 4};
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void heapSort(int a[]) {
        //1 init the heap
        initHeap(a);

        //2. shift the heap to sort
        for (int i = a.length; i > 1; i--) {
            int tmp = a[0];
            a[0] = a[i - 1];
            a[i - 1] = tmp;

            shiftHeap(a, 1, i - 1);
        }
    }

    public static void initHeap(int[] a) {
        for (int i = a.length / 2; i > 0; i--) {
            shiftHeap(a, i, a.length);
        }
    }

    public static void shiftHeap(int[] a, int parent, int heapLength) {
        int idxLargetst = parent;
        int idxLeftChild = parent * 2;
        int idxRightChild = parent * 2 + 1;

        if (heapLength >= idxLeftChild && a[idxLeftChild - 1] > a[parent - 1]) {
            idxLargetst = idxLeftChild;
        }

        if (heapLength >= idxRightChild && a[idxRightChild - 1] > a[idxLargetst - 1]) {
            idxLargetst = idxRightChild;
        }

        if (idxLargetst != parent) {
            int tmp = a[parent - 1];
            a[parent - 1] = a[idxLargetst - 1];
            a[idxLargetst - 1] = tmp;

            shiftHeap(a, idxLargetst, heapLength);
        }

    }
}

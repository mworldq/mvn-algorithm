package com.caocao.algorithm.sort;

import java.util.Arrays;

/**
 * Created by m on 16-10-24.
 */
public class MergeV2 {

    public static void main(String[] args) {
        int[] a = {6, 8, 2, 4, 9, 1, 0, 4};
        System.out.println(Arrays.toString(a));
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a, int idxStart, int idxEnd) {

        if (idxStart < idxEnd) {
            int mid = (idxStart + idxEnd) / 2;
            mergeSort(a, idxStart, mid);
            mergeSort(a, mid + 1, idxEnd);
            sort(a, idxStart, mid, idxEnd);
        }
    }

    public static void sort(int[] a, int idxStart, int idxMid, int idxEnd) {
        int[] temp = new int[idxEnd - idxStart + 1];

        int idxLeftStart = idxStart;
        int idxRightStart = idxMid + 1;
        int idxTemp = 0;

        while (idxLeftStart <= idxMid && idxEnd >= idxRightStart) {
            if (a[idxLeftStart] < a[idxRightStart]) {
                temp[idxTemp++] = a[idxLeftStart++];
            } else {
                temp[idxTemp++] = a[idxRightStart++];
            }
        }
        while (idxLeftStart <= idxMid) {
            temp[idxTemp++] = a[idxLeftStart++];
        }
        while (idxRightStart <= idxEnd) {
            temp[idxTemp++] = a[idxRightStart++];
        }

        for (int i = idxStart, j = 0; i < idxEnd + 1; i++, j++) {
            System.out.println("i:" + i + ", idxEnd:" + idxEnd);
            a[i] = temp[j];
        }

//        for (int i = idxStart, j = 0; j < temp.length; i++, j++) {
//            System.out.println("j:" + j + ", temp.length:" + temp.length);
//            a[i] = temp[j];
//        }

//        for (idxTemp = 0, idxLeftStart = idxStart; idxTemp < temp.length; idxTemp++, idxLeftStart++) {
//            a[idxLeftStart] = temp[idxTemp];
//        }
    }
}

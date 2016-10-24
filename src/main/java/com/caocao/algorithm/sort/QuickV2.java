package com.caocao.algorithm.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by m on 16-10-17.
 */

public class QuickV2 {

    public static void main(String args[]) {
        int[] a = {49, 38, 65, 12, 45, 5, 33};
        quicksort(a, 0, a.length-1);

        System.out.println("---");
        System.out.println(Arrays.toString(a));
        ArrayList l = new ArrayList(Arrays.asList(a));
        Collections.reverse(l);
        System.out.println(l.get(0));
    }

    static void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            System.out.println(Arrays.toString(n));
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }

}


package com.caocao.exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by m on 16-11-22.
 * <p>
 * 给一列无序数组，求出中位数并给出算法的时间复杂度。
 *
 * Coolection.sort 采用的是归并排序，时间复杂度 O(n\log n)
 */
public class T2 {

    public static void main(String[] args) {
        Integer[] a = {6, 4, 2, 8, 9, 1, 0, 4};
        Arrays.sort(a);
        System.out.println("a = " + a[0]);
        System.out.println("a.mid = " + a[a.length/2]);

//        List<Integer> list = Arrays.asList(a);
//        Collections.sort(list);
//        System.out.println("list = " + list);
//        System.out.println("list = " + list.get(list.size() / 2));
    }
}

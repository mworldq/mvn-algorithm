package com.caocao.exam;

import java.util.HashMap;

/**
 * Created by m on 16-10-27.
 * 数组中存放0到n中的缺少一个数的连续数，找出该缺少的数
 */
public class FindMissingV1 {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 6, 7, 8};

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            hm.put(i, a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            hm.remove(a[i]);
        }

        System.out.println(hm.keySet());
    }
}

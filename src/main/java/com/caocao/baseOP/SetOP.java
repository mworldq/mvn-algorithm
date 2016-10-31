package com.caocao.baseOP;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by caocao on 16/10/31.
 *  1.它不允许出现重复元素；
 2.不保证集合中元素的顺序
 3.允许包含值为null的元素，但最多只能有一个null元素。
 */
public class SetOP {
    public static void main(String[] args) {
        Set a = new HashSet<String>();
        a.add("aa");
        System.out.println(a.toString());

    }
}

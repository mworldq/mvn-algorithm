package com.caocao.baseOP;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by caocao on 16/10/31.
 */
public class ListOP {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("peter", "anna", "mike", "xenia"));
//        Collections.sort(names, (String n1, String n2) -> n1.compareTo(n2));
//        Collections.sort(names, ( n1,  n2) -> n1.compareTo(n2));
        System.out.println(names.toString());

        names.add("aaa");
        names.remove("aa");

        Iterator it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        names.remove("aaa");
        names.remove(0);


        System.out.println(names.toString());
    }
}

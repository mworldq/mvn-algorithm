package com.caocao.baseOP;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by caocao on 16/10/29.
 */
public class MapOP {
    public static void main(String[] args){
        HashMap<String, Integer> hm = new HashMap();
        hm.put("a", 1);
        hm.put("b", 2);
        hm.put("c", 3);

        System.out.println("hm-orgion:" + hm.size());

        HashMap<String, Integer> hm_c = (HashMap<String, Integer>)hm.clone();

        if(hm.containsKey("c")){
            hm.remove("c");
        }

        System.out.println("hm-update:" + hm.size());
        hm.putAll(hm_c);

        System.out.println("hm_c:" + hm_c.size());

        Iterator itKey = hm.keySet().iterator();
        while(itKey.hasNext()){
            System.out.println(hm.get(itKey.next()));
        }

        Iterator itValue = hm.values().iterator();
        while(itValue.hasNext()){
            System.out.println(itValue.next());
        }


    }


    static String genValue(String aa) {
        return aa;
    }

}

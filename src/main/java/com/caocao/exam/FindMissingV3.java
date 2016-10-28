package com.caocao.exam;

/**
 * Created by m on 16-10-27.
 * 现在有一大堆自然数组成的小到大数组arr，其中会有123456910  这样就要找到6(最先不连续的数字)
 */
public class FindMissingV3 {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,9,1,0};
        int i=0;
        while(a[i+1] - a[i] == 1){
            i++;
        }
        System.out.println(a[i]);
    }
}

package com.caocao.algorithm.sort;

import java.util.Arrays;

/**
 * Created by m on 16-10-18. 雞尾酒排序
    分类 -------------- 内部比较排序
    数据结构 ---------- 数组
    最差时间复杂度 ---- O(n^2)
    最优时间复杂度 ---- 如果序列在一开始已经大部分排序过的话,会接近O(n)
    平均时间复杂度 ---- O(n^2)
    所需辅助空间 ------ O(1)
    稳定性 ------------ 稳定
 */
public class BubbleV2 {


    public static void main(String[] args) {
        int[] a = {6,8,2,4,9,1,0,4};
        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void bubbleSort(int[] a){
        for(int i=0; i < a.length ; i=i+2){

            for(int j=0; j < a.length -1; j++){
                if(a[j] < a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }

            for(int j=a.length - i; j == 0; j--){
                if(a[j] < a[j-1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }
}

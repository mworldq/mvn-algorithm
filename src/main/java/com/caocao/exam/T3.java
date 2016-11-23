package com.caocao.exam;

import java.util.HashMap;

/**
 * Created by m on 16-11-22.
 * <p>
 * 给出10W条人和人之间的朋友关系，求出这些朋友关系中有多少个朋友圈（如A-B、B-C、D-E、E-F，这4对关系中存在两个朋友圈），
 * 并给出算法的时间复杂度。
 * <p>
 * A:并查集
 * 如果目标集合是int，可以考虑使用Node[]的方式保留关联关系；其他的方式，考虑map，毕竟map的效率对于大数据量比较低
 */
public class T3 {
    public static void main(String[] args) {
        Union_Find<String> uf = new Union_Find<String>();
        uf.union("s1", "s2");
        uf.union("s3", "s4");
        uf.union("s1", "s3");

        uf.union("s5", "s6");
        uf.union("s6", "s7");

        String str1 = uf.find("s5");
        String str2 = uf.find("s2");

        /*
            Union_Find<Integer> uf2=new Union_Find<Integer>();
			uf2.union(1, 2);
			uf2.union(3, 2);
			uf2.union(4, 2);
			uf2.union(5, 2);
			uf2.union(3, 5);
			uf2.union(2, 4);*/

        System.out.println(str1 + ":::::" + str2);
    }

    /**
     * 并查集，数据结构
     * 采用泛型编程
     * 采用指向父节点方式实现，即map.get(key)的值是父节点的key，根节点的key和value相等，也是一个并查集的入口
     *
     * @author "zhshl"
     * @date 2014-10-20
     */
    public static class Union_Find<T> {
        private HashMap<T, T> unionMap = new HashMap<T, T>(); //记录节点之间的关系
        private HashMap<T, Integer> unionSize = new HashMap<T, Integer>();///某个树的大小，某一个并查集的大小
        private int count = 0;///并查集数目


        /**
         * 获取并查集总数
         *
         * @return
         */
        public int getCount() {
            return count;
        }

        /**
         * 返回key属于的并查集的根的value,如果不存在key则返回NULL
         *
         * @param key
         * @return
         */
        public T find(T key) {

            if (!unionMap.containsKey(key)) {
                return null;
            }

            T value = unionMap.get(key);
            while (!value.equals(key)) {
                ///如果key和value不相等，则不是根节点

                ///路劲压缩，将该节点的父节点指向其爷爷节点
                unionMap.put(key, unionMap.get(unionMap.get(key)));

                key = value;
                if (!unionMap.containsKey(key)) {
                    return null;
                }
                value = unionMap.get(key);
            }
            return value;
        }

        /**
         * 将key1，key2加入并查集
         *
         * @param key1
         * @param key2
         */
        public void union(T key1, T key2) {
            ///首次加入则存入map中
            if (!unionMap.containsKey(key1)) {
                unionMap.put(key1, key1);
                unionSize.put(key1, 1);
                count++;
            }
            if (!unionMap.containsKey(key2)) {
                unionMap.put(key2, key2);
                unionSize.put(key2, 1);
                count++;
            }


            T root1 = find(key1);
            T root2 = find(key2);

            if (root1.equals(root2)) {
                ///如果已经属于同一个并查集，直接返回
                return;
            }


            if (unionSize.get(root1) > unionSize.get(root2)) {
                ////第一个并查集包含节点多时, 让第二颗树根节点指向第一颗树根节点,并修改对应的并查集大小
                unionMap.put(root2, root1);

                int size = unionSize.get(root1) + unionSize.get(root2);
                unionSize.put(root1, size);

            } else {
                unionMap.put(root1, root2);
                int size = unionSize.get(root1) + unionSize.get(root2);
                unionSize.put(root2, size);
            }
            count--;////总并查集数目减少一

        }
    }
}

package com.caocao.exam;

/**
 * Created by m on 16-11-3.
 * <p>
 * 假设淘宝一天有5亿条成交数据，求出销量最高的100个商品并给出算法的时间复杂度。
 * 8 * 500000000 / 1024 / 1024 /1024 = 3.75G
 * <p>
 * 思路一： 单线程流文件读取，以产品ID为名称落地成文件（如果内存太小）。取前100个最大文件。
 * <p>
 */


import java.io.FileInputStream;
import java.util.*;

/**
 * 思路二：单线程流文件读取，形成一个TriedTree。取前100个最大。（TRY, OK）
 */

public class T1 {

    private TrieNode root;
    private SortedMap<String, Integer> productIdMap;

    private char[] characterTable = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '0'};

    public T1() {
        root = new TrieNode();
        productIdMap = new TreeMap<String, Integer>();
    }

    public static void main(String[] args) throws Exception {
        T1 t = new T1();
        t.readFile("./src/main/resources/order_ids.txt");
        t.getCounter();
        t.getTopK();
    }

    public void readFile(String path) throws Exception {
        FileInputStream inputStream = null;
        Scanner sc = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                buildTriedTree(line);
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    public void buildTriedTree(String productId) {
        System.out.println("productId:" + productId);
        addProductId2Tree(productId);
    }

    public void addProductId2Tree(String productId) {
        TrieNode tn = root;
        for (int i = 0; i < productId.length(); i++) {
            if (!tn.children.containsKey(productId.charAt(i))) {
                tn.children.put(productId.charAt(i), new TrieNode());
            }
            tn = tn.children.get(productId.charAt(i));
        }
        tn.count++;
        tn.terminable = true;
    }

    public void getCounter() {
        traverse();
    }

    /**
     * 以字典序输出Tire中所有出现的单词及频数
     */
    public void traverse() {
        StringBuffer word = new StringBuffer("");
        TrieNode node = root;
        traverseTrie(node, word);
    }

    public void traverseTrie(TrieNode node, StringBuffer word) {
        if (node.terminable) {
            System.out.println(word + "------" + node.count);
            productIdMap.put(word.toString(), node.count);
            if (node.children.isEmpty())
                return;
        }
        for (int i = 0; i < characterTable.length; i++) {
            if (!(node.children.containsKey(characterTable[i])))
                continue;
            traverseTrie(node.children.get(characterTable[i]),
                    word.append(characterTable[i]));
            word.deleteCharAt(word.length() - 1);
        }
    }

    public void getTopK() {
        List<Map.Entry<String, Integer>> list_Data = new ArrayList<Map.Entry<String, Integer>>(productIdMap.entrySet());
        list_Data.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() != null && o1.getValue() != null && o2.getValue().compareTo(o1.getValue()) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println("list_Data = " + list_Data);
    }

    public class TrieNode {

        Map<Character, T1.TrieNode> children = null;
        int count = 0;
        boolean terminable = false;

        public TrieNode() {
            children = new HashMap<Character, T1.TrieNode>();
        }

    }
}

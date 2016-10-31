package com.caocao.algorithm.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caocao on 16/10/22.
 */
public class TiedTree {

    private TrieNode root;

    private char[] characterTable = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k',
            'l', // 遍历的时候使用
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z'};

    public TiedTree(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode tn = new TrieNode();
        for(int i=0; i<word.length(); i++) {
            if (!root.children.containsKey(word.charAt(i))) {
                root.children.put(word.charAt(i), new TrieNode());
            }
            tn = root.children.get(word.charAt(i));
        }
        tn.count++;
        tn.terminable = true;
    }

    public boolean del(TrieNode node, String word){
        if (word.length() == 0) {
            node.terminable = false; // 不要忘了这里信息的更新
            return node.children.isEmpty();
        }
        if (del(node.children.get(word.charAt(0)), word.substring(1))) {
            node.children.remove(word.charAt(0));
            if (node.children.isEmpty() && node.terminable == false) { // 注意第二个条件，假如有"abcd"与"abc",删除abcd时，要判断中间路径上是不是另一个子串的结束
                return true;
            }
        }
        return false;
    }

    public boolean find(String word){
        TrieNode tn = new TrieNode();
        for(int i=0; i< word.length(); i++){
            if(!root.children.containsKey(word.charAt(i))){
                return false;
            } else {
                tn = root.children.get(word.charAt(i));
            }
        }
        return tn.terminable;
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



    public class TrieNode {
        private Map<Character, TrieNode> children = null;
        private int count;
        private boolean terminable;

        public TrieNode(){
            count = 0;
            children = new HashMap<Character, TrieNode>();
            terminable = false;
        }

    }

    public static void main(String[] args){
        TiedTree tt = new TiedTree();

    }

}

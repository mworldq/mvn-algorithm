package com.caocao.exam;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by m on 16-11-7.
 * <p>
 * 设计包含min函数的栈。
 * 定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。
 * 要求函数min、push以及pop的时间复杂度都是O(1)。
 * <p>
 * 思路： 辅助栈
 */
public class MiniStack {

    LinkedList<Integer> standStack = new LinkedList();
    LinkedList<Integer> miniStack = new LinkedList();

    public int min() {
        return miniStack.getFirst();
    }

    public void push(int a) {
        standStack.push(a);
        miniStack.push(a);
        Collections.sort(miniStack, (o1, o2) -> o1.compareTo(o2));
    }

    public int pop() {
        int tmp = standStack.pop();
        miniStack.remove(miniStack.indexOf(tmp));
        return tmp;
    }

    public static void main(String[] args) {
        MiniStack ms = new MiniStack();
        ms.push(33);
        ms.push(22);
        ms.push(44);
        ms.push(4);
        ms.push(11);
        ms.push(44);
        System.out.println("standStack:" + ms.standStack);
        System.out.println("miniStack:" + ms.miniStack);
        System.out.println("Min:" + ms.min());

        ms.pop();
        ms.pop();
        System.out.println("standStack:" + ms.standStack);
        System.out.println("miniStack:" + ms.miniStack);
        System.out.println("Min:" + ms.min());
    }


}

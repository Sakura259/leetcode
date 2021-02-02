package com.haobai.leetcode.tree.扁平化嵌套列表迭代器;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haobai
 * @description: 341. NestedIterator
 * 可以用多叉树的遍历来解决 --- val   list遍历
 * @date 2020-12-02 22:51
 */
public class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> linkedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        linkedList = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return linkedList.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!linkedList.isEmpty() && !linkedList.get(0).isInteger()) {
            List<NestedInteger> list = linkedList.remove(0).getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                linkedList.addFirst(list.get(i));
            }
        }
        return !linkedList.isEmpty();
    }

}

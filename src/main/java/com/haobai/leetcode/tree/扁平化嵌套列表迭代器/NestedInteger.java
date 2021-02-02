package com.haobai.leetcode.tree.扁平化嵌套列表迭代器;

import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-12-02 23:01
 */
public interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}


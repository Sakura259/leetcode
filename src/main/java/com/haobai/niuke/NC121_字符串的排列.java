package com.haobai.niuke;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author haobai
 * @description:
 * @date 2021/3/8 10:50
 */
public class NC121_字符串的排列 {

    private ArrayList<String> list = new ArrayList<>();

    /**
     * 采用回溯的做法，对字符进行交换，最后加入到list中（需要判断是否存在，可能存在重复）
     * 最后通过Collections.sort 对其进行排序
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return list;
        }
        backTrack(str.toCharArray(), 0);
        Collections.sort(list);
        return list;
    }

    private void backTrack(char[] chars, int i) {
        if (i == chars.length - 1) {
            String value = String.valueOf(chars);
            if (!list.contains(value)) {
                list.add(value);
            }
            return;
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                backTrack(chars, i + 1);
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

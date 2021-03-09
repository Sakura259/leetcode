package com.haobai.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haobai
 * @description:
 * @date 2021/3/2 23:23
 */
public class 无重复字符的最长子串 {

    /**
     * 采用滑动窗口，用map来存已有的字符，如果碰到重复字符，那么left从当前最大的坐标重新开始
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}

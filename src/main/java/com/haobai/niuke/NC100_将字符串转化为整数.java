package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/3/8 11:54
 */
public class NC100_将字符串转化为整数 {

    /**
     * @param str string字符串
     * @return int整型
     */
    public int atoi(String str) {

        byte[] bytes = str.trim().getBytes();
        //返回值
        int value = 0;

        //正负字符byte值
        byte p = '+';
        byte n = '-';

        //0-9数字区间byte值
        byte zero = '0';
        byte nine = '9';

        if (bytes.length == 0) {
            return value;
        }

        //过滤掉非无用字符，并只用endIndex作为截断位
        int endIndex = 1;
        for (int i = 1; i < bytes.length; i++) {
            // 判断是否为0~9数字
            if (bytes[i] < zero || bytes[i] > nine) {
                endIndex = i;
                break;
            }
            endIndex = i + 1;
        }

        //判断过滤后的值是否为空
        if (endIndex == 0) {
            return value;
        }

        for (int i = 0; i < endIndex; i++) {

            //如果第一个字符是正负符号，continue不做计算
            if (i == 0 && (bytes[i] == p || bytes[i] == n)) {
                continue;
            }
            //如果是正值-=
            if (bytes[0] == n) {
                value -= (bytes[i] % zero) * Math.pow(10, endIndex - 1 - i);
                //否则+=
            } else {
                value += (bytes[i] % zero) * Math.pow(10, endIndex - 1 - i);
            }

        }

        return value;

    }
}

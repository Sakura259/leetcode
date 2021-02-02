package com.haobai.jvm.test;

import jdk.nashorn.internal.runtime.linker.Bootstrap;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author haobai
 * @description:
 * @date 2020-12-16 00:42
 */
public class Foo {
    static boolean boolValue;
    public static void main(String[] args) throws Exception {
        boolValue = true; // 将这个true替换为2或者3，再看看打印结果
        if (boolValue) System.out.println("Hello, Java!");
        if (boolValue == true) System.out.println("Hello, JVM!"); }
}

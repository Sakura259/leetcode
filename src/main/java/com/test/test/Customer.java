package com.test.test;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author haobai
 * @description:
 * @date 2021/3/26 19:14
 */
@Data
@AllArgsConstructor
public class Customer {

    private Integer userId;

    private String name;

    public void call() {
        System.out.println("咨询一些事");
    }
}

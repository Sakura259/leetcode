package com.haobai.concurrent.生产者消费者;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haobai
 * @description:
 * @date 2021/3/1 16:14
 */
@Data
@AllArgsConstructor
public class Resource {

    private ConcurrentHashMap<Integer, Integer> map;

    private Integer target;
}

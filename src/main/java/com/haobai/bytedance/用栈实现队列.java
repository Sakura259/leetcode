package com.haobai.bytedance;

import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=196&tqId=37108&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-total%2Fquestion-ranking&tab=answerKey
 * @date 2021/4/14 21:01
 */
public class 用栈实现队列 {

    private LinkedList<Integer> in = new LinkedList<>();

    private LinkedList<Integer> out = new LinkedList<>();


    public void push(Integer num) {
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        in.push(num);
    }

    public Integer pop() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.pop();
    }
}

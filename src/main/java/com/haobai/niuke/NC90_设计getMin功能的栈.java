package com.haobai.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2021/3/24 15:46
 */
public class NC90_设计getMin功能的栈 {

    private LinkedList<Integer> stack = new LinkedList<>();

    private LinkedList<Integer> minStack = new LinkedList<>();

    public int[] getMinStack (int[][] op) {
        // write code here
        int[] res = new int[op.length];
        if (op.length == 0) {
            return res;
        }
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < op.length; i++) {
            if(op[i][0] == 1) {
                stack.push(op[i][1]);
                if (minStack.isEmpty()) {
                    minStack.push(op[i][1]);
                } else {
                    minStack.push(Math.min(minStack.peek(), op[i][1]));
                }
            } else if (op[i][0] == 2) {
                minStack.pop();
                stack.pop();
            } else if (op[i][0] == 3) {
                list.add(minStack.peek());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

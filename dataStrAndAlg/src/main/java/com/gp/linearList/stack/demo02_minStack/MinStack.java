package com.gp.linearList.stack.demo02_minStack;

import java.util.Stack;

/**
 * min stack
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * @author lp
 * @since 2021/1/21 22:33:53
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    void pop() {
        stack.pop();
        minStack.pop();
    }

    int top() {
        return stack.peek();
    }

    int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(6);
        minStack.push(2);
        minStack.push(7);
        minStack.push(1);
        minStack.push(8);

        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

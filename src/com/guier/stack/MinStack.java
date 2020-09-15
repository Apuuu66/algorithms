package com.guier.stack;

import java.util.Stack;

/**
 * 155. Min Stack
 */
public class MinStack {
    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    public MinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
        dataStack.push(x);
    }

    public void pop() {
        if (dataStack.peek().equals(minStack.peek())) {
            dataStack.pop();
            minStack.pop();
        } else dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

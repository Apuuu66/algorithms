package com.guier.stack;

import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(9);
        stack.push(2);
        stack.push(6);
        stack.push(4);
        stack.push(8);
        Stack<Integer> sort = sort(stack);
        System.out.println(sort);
    }

    public static Stack<Integer> sort(Stack<Integer> A) {
        Integer c;
        Stack<Integer> B = new Stack<>();
        while (!A.isEmpty()) {
            c = A.peek();
            while (!B.isEmpty() && B.peek() < c) {
                A.push(B.pop());
            }
            B.push(c);
            while (A.peek() != c) {
                B.push(A.pop());
            }
            A.pop();
        }
        return B;
    }
}

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

    /**
     * 1. 先取出A的栈顶
     * 2. 当B不为空并且B栈顶小于c,将B中元素倒入A中
     * 3. 然后将C入栈，目的是 标记栈顶大于B中元素，无形排序
     * 4. 此时再将A中部分压入的元素倒回B中，结束条件A中元素不为标记栈顶
     * 5. 将标记栈顶从A出栈，完成排序
     * 6. 循环1-5，直至A为空
     *
     * 判断C是否大于B栈顶，大于就将B中小于C的元素倒入A中，B入栈C，后将A中倒入元素再倒出，再从A出栈C
     *
     */
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

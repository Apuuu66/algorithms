package com.guier.other;

import java.util.ArrayDeque;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * 输入: "3+2*2"
 * 输出: 7
 */
public class Calculator {
    public static void main(String[] args) {
        String str = "3+2*2";
        System.out.println(new Calculator().calculate(str));
    }

    private Integer calculate(String str) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char op = '+';
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (i == str.length() - 1 || !Character.isDigit(c)) {
                System.out.println(op + "" + num);
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                op = c;
                num = 0;
            }
        }
        int sum = 0;
        System.out.println(stack);
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}

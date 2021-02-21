package com.guier.other;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve("733064366", "459309139"));
    }

    /**
     * 大数相加
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        if (s == null || s.length() == 0) {
            return t;
        }
        if (t == null || t.length() == 0) {
            return s;
        }
        int maxLen = Math.max(s.length(), t.length());
        s = new StringBuilder(s).reverse().toString();
        t = new StringBuilder(t).reverse().toString();
        System.out.println(s);
        System.out.println(t);
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            int sum = 0;
            if (i < s.length()) {
                sum += s.charAt(i) - '0';
            }
            if (i < t.length()) {
                sum += t.charAt(i) - '0';
            }
            sum += carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}

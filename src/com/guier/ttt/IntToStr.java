package com.guier.ttt;

public class IntToStr {
    public static void main(String[] args) {
        Float a = 222.1215f;
        floatToStr(a);
    }

    private static void floatToStr(Float a) {
        int tmp = a.intValue();
        StringBuilder sb = new StringBuilder();
        while (tmp != 0) {
            int yushu = tmp % 10;
            tmp = tmp / 10;
            sb.insert(0, yushu);
        }
        System.out.println(sb);

        Float x = a - a.intValue();
        System.out.println(x);
        StringBuilder sx = new StringBuilder();

        while (x != 0.0) {
            x = x * 2;
            sx.append(x.intValue());
            if (x >= 1) {
                x = x - 1;
            }
        }
        System.out.println(sx);
        Double res = 0.0;
        for (int i = 0; i < sx.length(); i++) {
            int _i = sx.charAt(i) - 48;
            res = res + Math.pow(2, -(i + 1)) * _i;
        }
        System.out.println(res);
        System.out.println(sb.append(res));
    }
}

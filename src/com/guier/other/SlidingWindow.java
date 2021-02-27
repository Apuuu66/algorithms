package com.guier.other;

import java.util.ArrayList;

/**
 * 滑动窗口
 */
public class SlidingWindow {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int left = 0, right = 0;
        ArrayList<Integer> window = new ArrayList<>();
        while (right < list.size()) {
            window.add(list.get(right));
            right++;
            if (window.size() > 4) {
                window.remove(left);
                left++;
            }
        }
    }
}

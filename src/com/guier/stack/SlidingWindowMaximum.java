package com.guier.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. Sliding Window Maximum
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] slidingWindow = new SlidingWindowMaximum().maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(slidingWindow));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int newLen = nums.length - k + 1;
        int[] rtn = new int[newLen];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 滑动窗口： 滑的话 去头，移不符合，然后加入尾部，返回头部
            // dq.removeFirst();
            // dq.removeLast();
            // dq.addLast(i);
            // dq.getFirst();
            if (!dq.isEmpty() && dq.getFirst() < i - k + 1) {//判断是否出界，小于窗口的起始位置即出界，需移除。
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {//滑动窗口中一直保持窗口区间内最大值，窗口中元素不一定总是3个。
                dq.removeLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {//个数大于k的时候开始存对应窗口数值。
                rtn[i - k + 1] = nums[dq.getFirst()];
            }
            System.out.println(dq);
        }
        return rtn;
    }

    /**
     * 暴力解法 O(nk)
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int newLen = nums.length - k + 1;
        int[] rtn = new int[newLen];
        for (int start = 0; start < newLen; start++) {
            int end = start + k - 1;
            int tmp = nums[start];
            for (int j = start; j <= end; j++) {
                if (nums[j] > tmp) {
                    tmp = nums[j];
                }
            }
            rtn[start] = tmp;
        }
        return rtn;
    }

}


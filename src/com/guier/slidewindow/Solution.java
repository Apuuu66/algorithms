package com.guier.slidewindow;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
//       int[] nums = {1,2,4};
        int[] nums = {3, 9, 6};
        int k = 4;
        System.out.println(new Solution().maxFrequency(nums, k));
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int j = 0;
        long a = 0;
        for (int i = 1; i < nums.length; i++) {
            //计算区间内每个值，与区间内最后一个值相差的总和
            a += (nums[i] - nums[i - 1]) * (i - j);
            //如果超过目标值
            while (a > k) {
                //那么就减去区间内最左侧的值与最后一个值的差距。
                //然后再让区间左侧向右移动一位，相等于整个区间缩小了一位距离，在缩小的区间内再判断是否满足要求
                a -= nums[i] - nums[j];
                j++;
            }
            ans = Math.max(i - j + 1, ans);
        }
        return ans;
    }

//    public int maxFrequency(int[] nums, int k) {
//        Arrays.sort(nums);
//
//        int res = 1;
//        long sum = 0;
//        for (int i = 0, j = 0; j < nums.length; j++) {
//            sum += nums[j];
//
//            /* check how many number can be turned into nums[j]
//
//            <==>  turn all elements from nums[i : j] into nums[j]
//            <==>  need to add nums[j] * (j - i + 1) - sum of nums[i : j]
//
//            */
//            while (sum + k < nums[j] * (j - i + 1)) {
//                sum -= nums[i++];
//            }
//
//            res = Math.max(res, j - i + 1);
//        }
//
//        return res;
//    }
}

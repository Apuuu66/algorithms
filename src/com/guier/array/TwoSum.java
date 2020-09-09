package com.guier.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. Two Sum
 */
public class TwoSum {
    public static void main(String[] args) {
        int target = 33;
        int[] nums = new int[]{1, 3, 4, 11, 23, 22, 33, 77, 12};
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
